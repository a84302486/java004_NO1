package _01_ProductTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/_01_ProductTest/SelectFindByPrimaryKey")
public class SelectFindByPrimaryKey extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String productIdStr = request.getParameter("productId");
			Collection<ProductBean> coll =  new ProductDAO().findByPrimaryKey(productIdStr);

			System.out.println("搜尋產品序號: " + productIdStr);
			String toJson = new Gson().toJson(coll);
			out.println(toJson);
			out.flush();
			// request.setAttribute("productId", productIdStr);
			// request.setAttribute("productIdColl", coll);

			if (productIdStr != null && coll != null) {
				RequestDispatcher rd = request.getRequestDispatcher("SelectSuccess.jsp");
				rd.forward(request, response);
			} else {
				RequestDispatcher rd = request.getRequestDispatcher("SelectError.jsp");
				rd.forward(request, response);
			}
		} finally {
			out.close();
		}
	}
}