package _01_ProductTest;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
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
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String name ="123";
		response.setContentType("application/json; charset=UTF-8");
//		Collection<ProductBean> coll = new ProductDAO().findAll();
		PrintWriter out = response.getWriter();
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
		Gson gson = new Gson();
		out.println(gson.toJson(map));
        out.flush();
        return ;     	
//		request.setAttribute("productColl", coll);
//		RequestDispatcher rd = request.getRequestDispatcher("SelectAll.jsp");
//		rd.forward(request, response);
	}
}  