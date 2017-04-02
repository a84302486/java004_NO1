package _01_Product;

import java.io.IOException;
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

@WebServlet("/_01_Product/OnShelfControl.do")

public class OnShelfControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
    	
		ProductDAO pd = new ProductDAO();
		String productIdStr = request.getParameter("productId");
		String onShelfStr = request.getParameter("onShelf");	
		boolean onShelf = false;	
		
		if (onShelfStr.equalsIgnoreCase("true")) {
			onShelf = true;
		} else if (onShelfStr.equalsIgnoreCase("false")) {
			onShelf = false;
		}
		ProductBean pb = new ProductBean(productIdStr,onShelf);
		pd.CheckOnShelf(pb);
	}	
}