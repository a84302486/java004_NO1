package _01_Product;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import _05_Stock.StockDAO;

@WebServlet("/_01_Product/SelectProduct.do")
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
		
		String cmd = request.getParameter("cmd");
		String productIdStr = request.getParameter("productId");
		String productNameStr = request.getParameter("productName");
		String typeStr = request.getParameter("type");
		
		if(cmd ==null){
			return;
		}
		
		ProductDAO pd = new ProductDAO();
		// list輸出純文字資料
		List<ProductBean> list = null;
		response.setContentType("application/json; charset=UTF-8");
		// 輸出圖片資料
		// String mimeType = getServletContext().getMimeType(fileNameStr);
		// response.setContentType(mimeType);
		// String idStr = request.getParameter("id");
		// System.out.println(idStr);
		// byte[] bytes = null ;

		try (
				// PrintWriter pw = response.getWriter();
				OutputStream os = response.getOutputStream();) {

			if (cmd.equalsIgnoreCase("ALL")) {
				if (productIdStr.trim().length() == 0) {
					System.out.println("判定為null");
					list = pd.findAll();
				} else {
					System.out.println("搜尋" + productIdStr);
					list = pd.findByPrimaryKey(productIdStr);
				}

			} else if (cmd.equalsIgnoreCase("TYPE") && typeStr != null) {
				list = pd.findByType(typeStr);
			} else if (cmd.equalsIgnoreCase("SINGLE") && productIdStr.trim().length() != 0) {
				list = pd.findByPrimaryKey(productIdStr);
			} else if (cmd.equalsIgnoreCase("Name") && productNameStr.trim().length() != 0) {
				if(isInteger(productNameStr)){
					list = pd.findByPrice(productNameStr);
				}else{
					list = pd.findByName(productNameStr);
				}
				
			}

			// listToJson寫出純文字資料
			String listToJson = new Gson().toJson(list);
			os.write(listToJson.getBytes("UTF-8"));
			System.out.println(listToJson);

		}
	}
}
	
