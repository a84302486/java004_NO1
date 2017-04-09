package _21_ShoppingOrder;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class getScore
 */
@WebServlet("/_21_ShoppingOrder/getScoreServlet.do")
public class SetScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String scoreStr = request.getParameter("score");
		double score = Double.parseDouble(scoreStr);
		String orderIdStr = request.getParameter("orderId").trim();
		String productIdStr = request.getParameter("productId").trim();

		OrderDetailBeanDAO odbDAO = new OrderDetailBeanDAO();		
		odbDAO.setScore(score, orderIdStr, productIdStr);
		
		double scoreAvg = odbDAO.getScoreAvg(productIdStr);
		odbDAO.setScoreToProduct(scoreAvg,productIdStr);
		
		int comments = odbDAO.getProductComments(productIdStr);
		System.out.println("comments="+comments);
	}

}
