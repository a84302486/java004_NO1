package _05_Stock;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/_05_Stock/SelectStock.do")
public class SelectStock extends HttpServlet {
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
		String valStr = request.getParameter("val");

		StockDAO sd = new StockDAO();
		// list輸出純文字資料
		Collection<StockBean> list = null;
		response.setContentType("application/json; charset=UTF-8");

		try (OutputStream os = response.getOutputStream();) {

			if (cmd.equalsIgnoreCase("productId")) {
				if (valStr.trim().length() == 0) {
					System.out.println("判定為null");
					list = sd.findAll();
				} else {
					System.out.println("搜尋" + valStr);
					list = sd.findByPrimaryKey(valStr);
				}

			} else if (cmd.equalsIgnoreCase("stockMFG")) {
				list = sd.findByMFG(valStr);
			} else if (cmd.equalsIgnoreCase("stockEXP")) {
				list = sd.findByEXP(valStr);
			}

			// listToJson寫出純文字資料
			String listToJson = new Gson().toJson(list);
			os.write(listToJson.getBytes("UTF-8"));
			System.out.println(listToJson);

		}
	}
}
