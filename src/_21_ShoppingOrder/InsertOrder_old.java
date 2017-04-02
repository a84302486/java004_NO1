package _21_ShoppingOrder;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _01_Product.ProductBean;
import _01_Product.ProductDAO;
import _14_Member.MemberBean;

@WebServlet("/WebShop/Order.old")
public class InsertOrder_old extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		if(session == null){
			RequestDispatcher rd = request
					.getRequestDispatcher("/WebShop/login_and_register.jsp");
			rd.forward(request, response);
		}
		MemberBean mb=(MemberBean)session.getAttribute("MemberLoginOK");
		
		Map<String,String> map = new HashMap<String,String>();
		Enumeration<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
		    String key = (String) parameterNames.nextElement();
		    String val = request.getParameter(key);

		    map.put(key, val);  
		}
		
		// OrderBean
		
		String orderId = null;	
			SimpleDateFormat sdfsss = new SimpleDateFormat("yyyyMMddhhmmssSSS");
			orderId = sdfsss.format(new Date());
			
		String orderDate = null;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			orderDate = sdf.format(new Date());
			
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
			
			if(hour < 12){//今天中午12點前訂,明天中午12點過後出貨
				specialDate.add(Calendar.HOUR_OF_DAY, 24+(12-hour));
			}else{
				specialDate.add(Calendar.DAY_OF_MONTH, 2);
			}
			
			shippedDate = sdf.format(specialDate.getTime()).toString();

		String m_Username =  mb.getM_Username();
		Integer orderTotal = 0;
		
		OrderBean ord = new OrderBean(orderId, orderDate, shippedDate,  m_Username, orderTotal);
		
		System.out.println("-------------------------------------------------");
		System.out.println("OrderId = "+ord.getOrderId());
		System.out.println("OrderDate = "+ord.getOrderDate());
		System.out.println("ShippedDate = "+ord.getShippedDate());
		System.out.println("OrderTotal = "+ord.getOrderTotal());
		System.out.println("-------------------------------------------------");
		
		new OrderBeanDAO().insert(ord);
		System.out.println("-------------------------------------------------");
		
		
		//------------------------------------------------------
		//OrderDetailBean

		for (String key : map.keySet()) {

			ProductBean product;
			
				ProductDAO pd= new ProductDAO();
				product = pd.findByPrimaryKey(key).iterator().next();
				int price = product.getPgPrice();
			
			Integer quantity = Integer.parseInt(map.get(key));
			Integer subTotal = price*quantity;
			orderTotal += subTotal;
			
			OrderDetailBean ordDetail = new OrderDetailBean(orderId, product, quantity, subTotal);
			new OrderDetailBeanDAO().insert(ordDetail);
			
			
			System.out.println("SubTotal = "+ordDetail.getSubTotal());
			System.out.println("-------------------------------------------------");
		}
		
		new OrderBeanDAO().updateOrderTotal(orderId, orderTotal);
		System.out.println("OrderTotal = "+orderTotal);
		System.out.println("-------------------------------------------------");
		


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