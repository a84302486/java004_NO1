package WebShop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/WebShop/Order")
public class InsertOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		MemberBean mb=(MemberBean)session.getAttribute("MemberLoginOK");
		System.out.println("訂單會員 = "+mb.getM_Username());
		
		
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
		    String key = (String) parameterNames.nextElement();
		    String val = request.getParameter(key);
		    System.out.println("key = "+key+" ,value = "+val);
		    
		}
		
		OrderBean ord = new OrderBean(String.valueOf(PrimaryGenerater.getInstance()), 
									  "abc", 
									  "abc", 
									  mb.getM_Username(), 
									  0);
		
		System.out.println("OrderId = "+ord.getOrderId());
		System.out.println("OrderDate = "+ord.getOrderDate());
		
		response.setContentType("application/json; charset=UTF-8");
		String toJson = "success";
		
		try (PrintWriter out = response.getWriter();) {
			
		
			System.out.println(toJson);
			out.println(toJson);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}