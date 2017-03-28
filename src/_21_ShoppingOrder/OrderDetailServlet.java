package _21_ShoppingOrder;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/_21_ShoppingOrder/orderDetail")
public class OrderDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String M_Username = request.getParameter("Username");
		String OrderId = request.getParameter("OrderId");
	
		System.out.println("收到Username="+M_Username+", OrderId="+OrderId);
		try {
//			OrderDAO ordDAO = new OrderDAO();
//			OrderBean ob = ordDAO.getOrder(no);
//			request.setAttribute("OrderBean", ob);
			RequestDispatcher  rd = request.getRequestDispatcher("/_21_ShoppingOrder/ShowOrderDetail.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			throw new ServletException(e);
		} 
	}
}