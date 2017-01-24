package _02_Member;
import java.io.*;
import java.sql.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/_02_Member/register0403_v4.do")
public class Register0403_V4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
    	request.setCharacterEncoding("UTF-8");
		// 準備存放錯誤訊息的 List 物件
		List<String> errorMsg = new ArrayList<String>();
        request.setAttribute("ErrorMsgKey", errorMsg); 
		// 1. 讀取使用者輸入資料
        String Id = request.getParameter("Id");
		String userId = request.getParameter("username");
		String password = request.getParameter("pswd");
		String name = request.getParameter("userName");
		String eMail = request.getParameter("eMail");
		String tel = request.getParameter("tel");
		
		// 2. 進行必要的資料轉換
		
		
		// 3. 檢查使用者輸入資料
		if (Id == null || Id.trim().length() == 0) {
			errorMsg.add("會員卡號必須輸入");
		}
		if (userId == null || userId.trim().length() == 0) {
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
		if (tel == null || tel.trim().length() == 0) {
			errorMsg.add("電話號碼欄必須輸入");
		}
		
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
		// 4. 進行 Business Logic 運算
		RegisterService rs = new RegisterService();
		if (rs.idExists(Id)) {
			errorMsg.add("該代號 (" +  Id  + ") 已經存在，請換新的代號");
		}else if (rs.idExists(userId)) {
			errorMsg.add("該代號 (" +  userId  + ") 已經存在，請換新的代號");
		} 
		
		else {
			try {
				Member mem = new Member(Id,userId, password, name, eMail, tel);
				rs.insert(mem);
			} catch (Exception e) {
				errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
				e.printStackTrace();
			}
		}
		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		request.setAttribute("userIdKey", userId);
		if (errorMsg.isEmpty())	{			
			RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
			rd.forward(request, response);
			return ; 
		}  else {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
     }
}   