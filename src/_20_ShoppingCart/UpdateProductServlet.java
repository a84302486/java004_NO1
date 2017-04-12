package _20_ShoppingCart;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 本類別可修改購物車內的商品資料，包括刪除某項商品，修改某項商品的數量
@WebServlet("/_20_ShoppingCart/UpdateProductServlet.do")
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession session = null;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		session = request.getSession(false);
		if (session == null) {      // 使用逾時
			response.sendRedirect(getServletContext().getContextPath() + "/WebShop/shop_index.html");
			return;
		}
		//取出session物件內的ShoppingCart物件
		ShoppingCart sc= (ShoppingCart)session.getAttribute("ShoppingCart");
		if (sc == null) {
			// 如果找不到購物車(通常是Session逾時)，沒有必要往下執行
			// 導向首頁
			response.sendRedirect(getServletContext().getContextPath() + "/WebShop/shop_index.html" );
			return;
        }
		// cmd可能是DEL或是MOD
		String cmd = request.getParameter("cmd");
		String productIdStr = request.getParameter("productId");;		
		if (cmd.equalsIgnoreCase("DEL")) {
	        sc.deleteProduct(productIdStr); // 刪除購物車內的某項商品
//	        RequestDispatcher rd = request.getRequestDispatcher("/WebShop/cartEdit.jsp");
//		    rd.forward(request, response);
		    return;
		} else if (cmd.equalsIgnoreCase("MOD")) {
			String newQtyStr = request.getParameter("newQty");
			
			if(newQtyStr==null){
				System.out.println("newQtyStr為null");
				return;
			}
			int newQty = Integer.parseInt(newQtyStr.trim());
			sc.modifyQty(productIdStr, newQty);   // 修改某項商品的數項
//	        RequestDispatcher rd = request.getRequestDispatcher("/WebShop/cartEdit.jsp");
//		    rd.forward(request, response);
		    return;
		}
	}
}