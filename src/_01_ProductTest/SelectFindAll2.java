package _01_ProductTest;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



@WebServlet("/_01_ProductTest/SelectFindAll2")
public class SelectFindAll2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	 doGet(request,response);		
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		String productIdStr = request.getParameter("productId");
		
		try{
			if(productIdStr != null){
				Collection<ProductBean> coll =  new ProductDAO().findByPrimaryKey("productIdStr");
				String toJson = new Gson().toJson(coll);
				out.println(toJson);
				out.flush();
			}else if(!isInteger(productIdStr)){
//					errorMsg.add("必須是整數");	
				System.out.println("必須是整數");
			}else if(productIdStr == null){
			
				Collection<ProductBean> collAll = new ProductDAO().findAll();
				String toJson = new Gson().toJson(collAll);
				out.println(toJson);
				out.flush();  
			}
		}finally{
				out.close();
		}
	}
	
	public static boolean isInteger(String value) {
	    Pattern pattern = Pattern.compile("^[-+]?\\d+$");
	    return pattern.matcher(value).matches();
	}
}
	
//		request.setAttribute("productColl", coll);
//		RequestDispatcher rd = request.getRequestDispatcher("SelectAll.jsp");
//		rd.forward(request, response);
