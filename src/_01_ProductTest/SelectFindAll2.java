package _01_ProductTest;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		try {
		List<ProductBean> list = new ProductDAO().findAll();
		String toJson = new Gson().toJson(list);
		out.println(toJson);
        out.flush();  

//		request.setAttribute("productColl", coll);
//		RequestDispatcher rd = request.getRequestDispatcher("SelectAll.jsp");
//		rd.forward(request, response);
		} finally {
			out.close();
		}
	}
}
