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

		String customer_id = request.getParameter("Customer_id");
		String simple_Name = request.getParameter("Simple_Name");
		String name = request.getParameter("Name");
		String sale_Path = request.getParameter("Sale_Path");
		String telephone = request.getParameter("Telephone");
		String fax = request.getParameter("Fax");
		String contacter = request.getParameter("Contacter");
		String address = request.getParameter("Address");
		String uniform_NO = request.getParameter("Uniform_NO");
		String this_Invertory_Date = request.getParameter("This_Invertory_Date");
		String last_Invertory_Date = request.getParameter("Last_Invertory_Date");
		String pR_Status = request.getParameter("PR_Status");
		String current_Discount_id = request.getParameter("Current_Discount_id");
		String next_Discount_id = request.getParameter("Next_Discount_id");
		String tax_Type = request.getParameter("Tax_Type");
		String uRL = request.getParameter("URL");
		String principal_Name = request.getParameter("Principal_Name");
		String contact_Name = request.getParameter("Contact_Name");
		String email = request.getParameter("Email");
		String line = request.getParameter("Line");
		String skype = request.getParameter("Skype");
		



		// 2. 進行必要的資料轉換

		// 3. 檢查使用者輸入資料
		if (customer_id == null || customer_id.trim().length() == 0) {
			errorMsg.add("會員卡號必須輸入");
		}
		if (name == null || name.trim().length() == 0) {
			errorMsg.add("帳號欄必須輸入");
		}
		
		

		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
			rd.forward(request, response);
			return;
		}

		String insertError = null;
		try {
			CustomerBean mem = new CustomerBean(customer_id, simple_Name, name, sale_Path, telephone, fax, contacter,
					address, uniform_NO, this_Invertory_Date, last_Invertory_Date, pR_Status, current_Discount_id,
					next_Discount_id, tax_Type, uRL, principal_Name, contact_Name, email, line, skype);
			
			insertError = new CustomerDAO().insert(mem);
		} catch (Exception e) {
			errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
			e.printStackTrace();
		}
		if (insertError != null) {
			errorMsg.add(insertError);
		}

		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		request.setAttribute("Customer_id", customer_id);
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