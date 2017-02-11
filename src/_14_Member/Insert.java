package _14_Member;

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

@WebServlet("/_14_Member/insert.do")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		// 準備存放錯誤訊息的 List 物件
		List<String> errorMsg = new ArrayList<String>();

		request.setAttribute("ErrorMsgKey", errorMsg);

		// 1. 讀取使用者輸入資料

		String id = request.getParameter("ID");
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String name = request.getParameter("Name");
		String nick = request.getParameter("Nick");
		String sex = request.getParameter("Sex");
		String birthday = request.getParameter("Birthday");
		String eMail = request.getParameter("EMail");
		String phone = request.getParameter("Phone");
		String cellPhone = request.getParameter("Cellphone");
		String address = request.getParameter("Address");
		String line = request.getParameter("Line");
		String faceBook = request.getParameter("FaceBook");
		String identityCard = request.getParameter("IdentityCard");
		String invoice = request.getParameter("Invoice");
		String uniformNumber = request.getParameter("UniformNumber");

		// 取得現在時間
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String joinDate = sdFormat.format(date);

		// 2. 進行必要的資料轉換

		// 3. 檢查使用者輸入資料
		if (id == null || id.trim().length() == 0) {
			errorMsg.add("會員卡號必須輸入");
		}
		if (username == null || username.trim().length() == 0) {
			errorMsg.add("帳號欄必須輸入");
		}
		if (password == null || password.trim().length() == 0) {
			errorMsg.add("密碼欄必須輸入");
		}
		if (name == null || name.trim().length() == 0) {
			errorMsg.add("姓名欄必須輸入");
		}
		if (eMail == null || eMail.trim().length() == 0) {
			errorMsg.add("EMail欄必須輸入");
		}
		if (phone == null || phone.trim().length() == 0) {
			errorMsg.add("電話號碼欄必須輸入");
		}

		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
			rd.forward(request, response);
			return;
		}

		String insertError = null;
		try {
			UserBean mem = new UserBean(id, username, password, name, nick, sex, birthday, eMail, phone, cellPhone,
					address, line, faceBook, identityCard, invoice, uniformNumber, joinDate,0,0,0);
			insertError = new MemberDAO().insert(mem);
		} catch (Exception e) {
			errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
			e.printStackTrace();
		}
		if (insertError != null) {
			errorMsg.add(insertError);
		}

		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		request.setAttribute("M_Username", username);
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