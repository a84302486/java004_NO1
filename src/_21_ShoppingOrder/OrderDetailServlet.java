package _21_ShoppingOrder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

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
			Collection<OrderDetailBean> coll = new ArrayList<>();
			OrderDetailBeanDAO odDAO = new OrderDetailBeanDAO();
			OrderBeanDAO oDAO = new OrderBeanDAO();
			coll = odDAO.select(OrderId);			
			String OrderDate = oDAO.selectOrderDate(OrderId);
			
			request.setAttribute("OrderDetail_coll", coll);
			request.setAttribute("OrderDate", OrderDate);
			RequestDispatcher  rd = request.getRequestDispatcher("/WebShop/ShowOrderDetail.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			throw new ServletException(e);
		} 
	}
}