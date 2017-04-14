package _22_ShoppingTrackingList;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import _01_Product.ProductBean;
import _14_Member.MemberBean;
import _21_ShoppingOrder.OrderDetailBean;
import _21_ShoppingOrder.OrderDetailBeanDAO;




@WebServlet("/_21_ShoppingOrder/SelectTtacking.do")
public class SelectTracking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
	
		HttpSession session = request.getSession();
		MemberBean mb = (MemberBean) session.getAttribute("MemberLoginOK");

//		String usernameStr = mb.getM_Username();
		String usernameStr = "user1@gmail.com";
		try {
			Collection<ProductBean> coll = new ArrayList<>();
			TrackingDAO tkDAO = new TrackingDAO();
			coll = tkDAO.select(usernameStr);
			request.setAttribute("TrackingList_coll", coll);
			RequestDispatcher  rd = request.getRequestDispatcher("/WebShop/TrackingList.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			throw new ServletException(e);
		} 


	}



}