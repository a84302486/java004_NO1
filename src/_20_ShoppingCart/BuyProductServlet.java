package _20_ShoppingCart;

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


@WebServlet("/_20_BuyProductServlet/BuyProductServlet.do")
public class BuyProductServlet extends HttpServlet {
	// 當使用者按下『加入購物車』時，瀏覽器會送出請求到本程式
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		HttpSession session = request.getSession(false) ; 
		ShoppingCart cart = (ShoppingCart)session.getAttribute("ShoppingCart");	
		if(cart == null) return;
		
		try (PrintWriter out = response.getWriter();) {
		String toJson = new Gson().toJson(cart.getContent());
		System.out.println(toJson);
		out.println(toJson);
		}
//		request.setAttribute("productBean", cart.getContent());
//		RequestDispatcher rd = request.getRequestDispatcher("cartEdit.jsp");
//		rd.forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession() ; 
		System.out.println("POST:session=" + session);
		
		if (session.isNew() ) {
			System.out.println("這是一個新的session");  
		} else {
			System.out.println("這是一個舊的session");			
		}

		 // 使用逾時跳回購物網登入畫面
//		if (session == null) {     
//			request.setAttribute("Errors", "使用逾時，請重新登入");
//			RequestDispatcher rd = request.getRequestDispatcher("/WebShop/login_and_register.jsp");
//			rd.forward(request, response);
//			return;
//		}
	
		// 取出存放在session物件內的ShoppingCart物件
		ShoppingCart cart = (ShoppingCart)session.getAttribute("ShoppingCart");
		System.out.println("get from session=" + cart);
		// 如果找不到ShoppingCart物件
		if (cart == null) {
			// 新建ShoppingCart物件
			cart = new ShoppingCart();
			// 將此新建ShoppingCart的物件放到session物件內
			session.setAttribute("ShoppingCart", cart);   // ${ShoppingCart.zzz}
		}

		String productIdStr = request.getParameter("productId");
		String nameStr 		= request.getParameter("name");
		String pgPriceStr = request.getParameter("pgPrice");
		String qtyStr 		= request.getParameter("qty");

		int qty = 0 ; 
		int pgPrice = 0 ; 
		
		try{
			// 進行資料型態的轉換
			qty = Integer.parseInt(qtyStr.trim());
			pgPrice = Integer.parseInt(pgPriceStr.trim());
		} catch(NumberFormatException e){
			throw new ServletException(e); 
		}
		System.out.println("productId=" + productIdStr + ",name="+ nameStr + ",price="+ pgPrice +",qty="+qty );
		System.out.println("Content="+cart.getContent());
		System.out.println("-------------------------");
		// 將訂單資料封裝到OrderItemBean內
		OrderItemBean oi = new OrderItemBean(productIdStr, nameStr, pgPrice, qty);

		// 將OrderItemBean加入ShoppingCart的物件內
		cart.addToCart(productIdStr, oi);

	}
}