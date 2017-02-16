package _14_Member;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _01_Product.ProductDAO;

@WebServlet("/_14_Member/Insert")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		// 準備存放錯誤訊息的 List 物件
		Map<String, String> errorMsg = new HashMap<>();

		request.setAttribute("ErrorMsg", errorMsg);
		request.setCharacterEncoding("UTF-8");

		// 1. 讀取使用者輸入資料

		String id = request.getParameter("ID");
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String password2 = request.getParameter("Password2");
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
		String insertDate = sdFormat.format(date);


		// 3. 檢查使用者輸入資料
		if (id == null || id.trim().length() == 0) {
			errorMsg.put("id","卡號必須輸入");
		}
		if (username == null || username.trim().length() == 0) {
			errorMsg.put("username","帳號必須輸入");
		}
		if (password == null || password.trim().length() == 0) {
			errorMsg.put("password","密碼必須輸入");
		}
		if (password2 == null || password2.trim().length() == 0) {
			errorMsg.put("password2","確認密碼必須輸入");
		}
		if (name == null || name.trim().length() == 0) {
			errorMsg.put("name","名稱必須輸入");
		}
		

		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("InsertMember.jsp");
			rd.forward(request, response);
			return;
		}

		//String insertError = null;
		try {
		
			MemberBean mem = new MemberBean(id, username, password, name, nick, sex, birthday, eMail, phone, cellPhone,
					address, line, faceBook,identityCard, invoice, uniformNumber, insertDate,insertDate,0,0,0);
			insertError = new MemberDAO().insert(mem);
			
		} catch (Exception e) {
			errorMsg.put("exception","資料庫存取錯誤");
			System.out.println("資料庫存取錯誤");
			e.printStackTrace();
		}
	
		System.out.println(username+" 新增成功");
		request.setAttribute("M_Username", username);
	
			RequestDispatcher rd = request.getRequestDispatcher("InsertMember.jsp");
			rd.forward(request, response);
		
		
	}
}