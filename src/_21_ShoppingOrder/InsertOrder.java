package _21_ShoppingOrder;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _01_ProductTest.ProductBean;
import _01_ProductTest.ProductDAO;
import _14_Member.MemberBean;
import _20_ShoppingCart.OrderItemBean;
import _20_ShoppingCart.ShoppingCart;

@WebServlet("/_21_ShoppingOrder/Order")
public class InsertOrder extends HttpServlet {
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
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");
		if(cart==null){
			return;
		}

		// OrderBean
		
		//orderId
		String orderId = null;
		SimpleDateFormat sdfsss = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		orderId = sdfsss.format(new Date());

		//orderDate
		String orderDate = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		orderDate = sdf.format(new Date());

		//shippedDate
		String shippedDate = null;
		Date dateParse = null;
		try {
			dateParse = sdf.parse(orderDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar specialDate = Calendar.getInstance();
		specialDate.setTime(dateParse);
		int hour = specialDate.get(Calendar.HOUR_OF_DAY);

		if (hour < 12) {// 今天中午12點前訂,明天中午12點過後出貨
			specialDate.add(Calendar.HOUR_OF_DAY, 24 + (12 - hour));
		} else {
			specialDate.add(Calendar.DAY_OF_MONTH, 2);
		}

		shippedDate = sdf.format(specialDate.getTime()).toString();

		
		//m_Username
		String m_Username = mb.getM_Username();
		Integer orderTotal = 0;

		OrderBean ord = new OrderBean(orderId, orderDate, shippedDate, m_Username, orderTotal);

		System.out.println("-------------------------------------------------");
		System.out.println("OrderId = " + ord.getOrderId());
		System.out.println("OrderDate = " + ord.getOrderDate());
		System.out.println("ShippedDate = " + ord.getShippedDate());
		System.out.println("OrderTotal = " + ord.getOrderTotal());
		System.out.println("-------------------------------------------------");

		new OrderBeanDAO().insert(ord);
		System.out.println("-------------------------------------------------");
		//---------------------------------------------------------------------------
		
		//OrderDetailBean
		
		
		for (Object key : cart.getContent().keySet()) {
			
			OrderItemBean temp = cart.getContent().get(key);
			ProductBean product;

			ProductDAO pd = new ProductDAO();
			product = pd.findByPrimaryKey(temp.getProductId()).iterator().next();

			Integer price = temp.getPgPrice();
			Integer quantity = temp.getQty();
			Integer subTotal = price * quantity;
			orderTotal += subTotal;

			OrderDetailBean ordDetail = new OrderDetailBean(orderId, product, quantity, subTotal);
			new OrderDetailBeanDAO().insert(ordDetail);

			System.out.println("SubTotal = " + ordDetail.getSubTotal());
			System.out.println("-------------------------------------------------");
		}
		//----------------------------------------------------------------------------
		
		//updateOrderTotal
		
		new OrderBeanDAO().updateOrderTotal(orderId, orderTotal);
		System.out.println("OrderTotal = " + orderTotal);
		System.out.println("-------------------------------------------------");
		
		//----------------------------------------------------------------------------
		
		
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