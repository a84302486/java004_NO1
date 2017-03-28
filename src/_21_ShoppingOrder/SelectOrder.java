package _21_ShoppingOrder;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import _14_Member.MemberBean;




@WebServlet("/_21_ShoppingOrder/SelectOrder")
public class SelectOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String M_Username = request.getParameter("Username");		
		System.out.println("收到Username = "+M_Username);
	
		Collection<OrderBean> coll = null;
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		String toJson = null;
	
		try (PrintWriter out = response.getWriter();) {

			coll = new OrderBeanDAO().select(M_Username);
			
			toJson = new Gson().toJson(coll);
			System.out.println(toJson);
			out.println(toJson);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}