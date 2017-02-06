package _07_Customer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/_07_Customer/insert.do")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		// 準備存放錯誤訊息的 List 物件
		List<String> errorMsg = new ArrayList<String>();

		request.setAttribute("ErrorMsgKey", errorMsg);

		// 1. 讀取使用者輸入資料

		String customerIdStr = request.getParameter("CustomerId");
		String simpleNameStr = request.getParameter("SimpleName");
		String nameStr = request.getParameter("Name");
		String salePathStr = request.getParameter("SalePath");
		String telephoneStr = request.getParameter("Telephone");
		String faxStr = request.getParameter("Fax");
		String contacterStr = request.getParameter("Contacter");
		String addressStr = request.getParameter("Address");
		String uniformNOStr = request.getParameter("UniformNO");
		String thisInvertoryDateStr = request.getParameter("ThisInvertory_Date");
		String lastInvertoryDateStr = request.getParameter("LastInvertory_Date");
		String prStatusStr = request.getParameter("PRStatus");
		String currentDiscountIdStr = request.getParameter("CurrentDiscountId");
		String nextDiscountIdStr = request.getParameter("NextDiscountId");
		String taxTypeStr = request.getParameter("TaxType");
		String urlStr = request.getParameter("URL");
		String principalNameStr = request.getParameter("PrincipalName");
		String contactNameStr = request.getParameter("ContactName");
		String emailStr = request.getParameter("Email");
		String lineStr = request.getParameter("Line");
		String skypeStr = request.getParameter("Skype");
		
		// 2. 進行必要的資料轉換

		// 3. 檢查使用者輸入資料
		if (customerIdStr == null || customerIdStr.trim().length() == 0) {
			errorMsg.add("會員卡號必須輸入");
		}
		if (nameStr == null || nameStr.trim().length() == 0) {
			errorMsg.add("帳號欄必須輸入");
		}
		
		

		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
			rd.forward(request, response);
			return;
		}

		String insertError = null;
		try {
			CustomerBean mem = new CustomerBean(customerIdStr, simpleNameStr, nameStr, salePathStr, telephoneStr, 
					faxStr, contacterStr, addressStr, uniformNOStr, thisInvertoryDateStr, lastInvertoryDateStr, prStatusStr, 
					currentDiscountIdStr, nextDiscountIdStr, taxTypeStr, urlStr, principalNameStr, contactNameStr, emailStr,
					lineStr, skypeStr);
					
			
			insertError = new CustomerDAO().insert(mem);
		} catch (Exception e) {
			errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
			e.printStackTrace();
		}
		if (insertError != null) {
			errorMsg.add(insertError);
		}

		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		request.setAttribute("CustomerId", customerIdStr);
		if (errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("InsertSuccess.jsp");
			rd.forward(request, response);
			return;
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
			rd.forward(request, response);
			return;
		}
	}
}