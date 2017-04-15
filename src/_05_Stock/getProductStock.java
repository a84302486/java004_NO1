package _05_Stock;

import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/_05_Stock/getProductStock.do")

public class getProductStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String productIdStr = null; // 查詢單筆商品會用到此代號
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