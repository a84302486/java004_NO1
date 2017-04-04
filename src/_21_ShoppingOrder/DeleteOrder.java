package _21_ShoppingOrder;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _14_Member.MemberBean;

@WebServlet("/_21_ShoppingOrder/DeleteOrder")
public class DeleteOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		if (session == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/WebShop/login_and_register.jsp");
			rd.forward(request, response);
			return;
		}
		MemberBean mb = (MemberBean) session.getAttribute("MemberLoginOK");
		if(mb==null){
			 response.sendRedirect(response.encodeRedirectURL("/WebShop/login_and_register.jsp"));
			 return;
		}
			
		//orderId
		String orderId = request.getParameter("OrderId");
		System.out.println("DeleteOrder 收到OrderId = "+orderId);
		
		new OrderDetailBeanDAO().delete(orderId);
		new OrderBeanDAO().delete(orderId);
		
		response.setContentType("text/html; charset=utf-8");
		
		RequestDispatcher rd =request.getRequestDispatcher("/WebShop/memberManage.jsp");
		rd.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}