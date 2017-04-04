package _05_Stock;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import _01_Product.ProductDAO;

@WebServlet("/_05_Stock/InsertStock.do")

public class InsertStock extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		ProductDAO pd = new ProductDAO();

		// 準備存放錯誤訊息的 List 物件
		List<String> errorMsg = new ArrayList<String>();

		String productIdStr = request.getParameter("productId");
		String quantityStr = request.getParameter("quantity");
		int quantity = 0;

		if (productIdStr == null || productIdStr.trim().length() == 0) {
			errorMsg.add("序號必須輸入");
		} else if (!isInteger(productIdStr)) {
			errorMsg.add("序號必須是整數");
		} else if (!pd.ifExist(productIdStr)) {
			errorMsg.add("序號不存在請重新輸入");
		}

		if (quantityStr == null || quantityStr.trim().length() == 0) {
			errorMsg.add("數量必須輸入");
		} else if (!isInteger(quantityStr)) {
			errorMsg.add("數量必須是整數");
		} else {
			quantity = Integer.parseInt(quantityStr);
		}

		// 取輸入時間(毫秒)當庫存批號
		String StockId = "S" + new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date());
		// 取該產品的保存期限
		int life = new StockDAO().getProductLife(productIdStr);
		// 取輸入時間(日期)當產品製造日
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String mfg = sdf.format(new Date());

		// 取得當地日期時間
		Calendar localDate = Calendar.getInstance();
		try {
			// 將字串轉為時間
			Date dateParse = sdf.parse(mfg);
			// 取得java.util.GregorianCalendar[time=1491235200000...]
			localDate.setTime(dateParse);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// 換算life天數為幾月幾號,然後加入日曆內
		localDate.add(Calendar.DAY_OF_MONTH, life);
	
		// 到期日localDate.getTime()=mfg+life ,轉成格式yyyy/MM/dd
		String exp = sdf.format(localDate.getTime()).toString();

		System.out.println("Product life=" + life);
		System.out.println("StockId=" + StockId);
		System.out.println("mfg=" + mfg);
		System.out.println("exp=" + exp);

		try (PrintWriter out = response.getWriter();) {
			String toJson = null;

			StockBean sb = new StockBean(StockId, productIdStr, mfg, exp, quantity);
	
			if (!errorMsg.isEmpty()) {
				toJson = new Gson().toJson(errorMsg);
			} else {
				new StockDAO().insert(sb);				
				String s = "產品序號: " + productIdStr + "庫存新增成功";
				toJson = new Gson().toJson(s);
			}

			System.out.println(toJson);
			out.println(toJson);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean isInteger(String value) {
		Pattern pattern = Pattern.compile("^[-+]?\\d+$");
		return pattern.matcher(value).matches();
	}

	public static boolean isDouble(String value) {
		Pattern pattern = Pattern.compile("^([-+]?\\d+)(\\.\\d+)?$");
		return pattern.matcher(value).matches();
	}
}
