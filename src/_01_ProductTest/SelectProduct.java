package _01_ProductTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/_01_ProductTest/SelectProduct.do")
public class SelectProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static boolean isInteger(String value) {
		Pattern pattern = Pattern.compile("^[-+]?\\d+$");
		return pattern.matcher(value).matches();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	
		request.setCharacterEncoding("UTF-8");
		
		ProductDAO pd= new ProductDAO();
		String productIdStr = request.getParameter("productId");
		Collection<ProductBean> coll = null;
		response.setContentType("application/json; charset=UTF-8");
		
		try (PrintWriter out = response.getWriter();) {
			if (productIdStr == null || productIdStr.trim().length() == 0) {
				System.out.println("判定為null");
				coll = pd.findAll();	
			} else if (!isInteger(productIdStr)) {
				// errorMsg.add("必須是整數");
				System.out.println("必須是整數");
			}else {
				coll = pd.findByPrimaryKey(productIdStr);
			}	
			String toJson = new Gson().toJson(coll);
			out.println(toJson);
		}
	}
}


// request.setAttribute("productColl", coll);
// RequestDispatcher rd = request.getRequestDispatcher("SelectAll.jsp");
// rd.forward(request, response);
