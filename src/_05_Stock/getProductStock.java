package _05_Stock;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import _01_Product.ProductDAO;

@WebServlet("/_05_Stock/getProductStock.do")

public class getProductStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
    	
		String productIdStr = request.getParameter("productId");	
		
		try (OutputStream os = response.getOutputStream();) {
			
			int quantity = new StockDAO().getProductStock(productIdStr);
			// listToJson寫出純文字資料
			String listToJson = new Gson().toJson(quantity);
			os.write(listToJson.getBytes("UTF-8"));
			System.out.println(listToJson);

		}

	}	
}