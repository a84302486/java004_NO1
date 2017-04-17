package _22_ShoppingTrackingList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;
import _14_Member.MemberBean;


@WebServlet("/_22_ShoppingTrackingList/InsertTracking.do")
public class InsertTracking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		List<String> errorMsg = new ArrayList<String>();
		TrackingDAO tkDAO = new TrackingDAO();

		HttpSession session = request.getSession();
		if (session == null) {
			response.sendRedirect(response.encodeRedirectURL("../WebShop/login_and_register.jsp"));
			// RequestDispatcher rd = request.getRequestDispatcher("../WebShop/login_and_register.jsp");
			// rd.forward(request, response);
			System.out.println("session == null");
		
		}
		MemberBean mb = (MemberBean) session.getAttribute("MemberLoginOK");
		if (mb == null) {
			
			// RequestDispatcher rd =request.getRequestDispatcher("/java004/WebShop/login_and_register.jsp");
			// rd.forward(request, response);
			errorMsg.add("請先登入");
//			response.sendRedirect(response.encodeRedirectURL(getServletContext().getContextPath()
//			+"/WebShop/login_and_register.jsp"));
			System.out.println("mb==null");
			
			RequestDispatcher rd = request
					.getRequestDispatcher("/WebShop/login_and_register.jsp");
			rd.forward(request, response);
			return;
		}
		String usernameStr = null;
		String productIdStr = null;
		
		try {
			usernameStr = mb.getM_Username();
			productIdStr = request.getParameter("productId");			
			if (tkDAO.ifExist(productIdStr,usernameStr)) {
				errorMsg.add("該產品已存在追蹤清單");
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		TrackingBean tb = new TrackingBean(usernameStr, productIdStr);
		try (PrintWriter out = response.getWriter();) {

			String toJson = null;

			if (!errorMsg.isEmpty()) {
				toJson = new Gson().toJson(errorMsg);
			} else {
				tkDAO.insert(tb);
				String s = "追蹤成功";
				toJson = new Gson().toJson(s);
			}

			out.println(toJson);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}