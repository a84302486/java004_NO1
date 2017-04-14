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

@WebServlet("/_22_ShoppingTrackingList/DeleteTracking.do")
public class DeleteTracking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		String productIdStr = request.getParameter("productId");	

		try (PrintWriter out = response.getWriter();) {
			String toJson = null;
			TrackingDAO tkDAO = new TrackingDAO();
			tkDAO.delete(productIdStr);
			String s = "刪除追蹤成功";
			toJson = new Gson().toJson(s);
			out.println(toJson);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}