package _20_ShoppingCart;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/_20_BuyProductServlet/ProcessOrderServlet.do")
public class ProcessOrderServlet extends HttpServlet {
	// 當使用者按下『加入購物車』時，瀏覽器會送出請求到本程式
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		// List<OrderItemBean> list = new ArrayList<>();
		HttpSession session = request.getSession(false);
		System.out.println("11111GET:session=" + session);
		ShoppingCart cart = (ShoppingCart) session.getAttribute("ShoppingCart");

		// try (PrintWriter out = response.getWriter();) {
		// String toJson = new Gson().toJson(cart.getContent());
		// System.out.println(toJson);
		// out.println(toJson);

		request.setAttribute("productBean", cart.getContent());
		RequestDispatcher rd = request.getRequestDispatcher("/WebShop/cartEdit.jsp");
		rd.forward(request, response);

	}
}
