package _14_Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import _00_Util.AES;
import _00_Util.SerialNumGenerator;

@WebServlet("/_14_Member/SearchPassword")

public class SearchPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");

		// 準備存放錯誤訊息的 List 物件
		List<String> errorMsg = new ArrayList<String>();

		// 傳送錯誤訊息的 List物件至JSP
		request.setAttribute("ErrorMsgKey", errorMsg);

		// 讀取輸入的資料
		String checkEmail = request.getParameter("checkEmail");
		String checkBirthday = request.getParameter("checkBirthday");
		String checkPhoneNumber = request.getParameter("checkPhoneNumber");
		if (checkEmail == null || checkEmail.trim().length() == 0) {
			errorMsg.add("帳號必須輸入");
		}
		if (checkBirthday == null || checkBirthday.trim().length() == 0) {
			errorMsg.add("生日必須輸入");
		}

		if (checkPhoneNumber == null || checkPhoneNumber.trim().length() == 0) {
			errorMsg.add("電話號碼必須輸入");
		}

		try (PrintWriter out = response.getWriter();) {

			MemberDAO mDAO = new MemberDAO();
			String toJson = null;
			String password = null;

			if (!errorMsg.isEmpty()) {
				toJson = new Gson().toJson(errorMsg);
			} else {
				MemberBean mb = mDAO.findMemberByUBC(checkEmail, checkBirthday, checkPhoneNumber);
				if (mb != null) {
					//驗證成功
					
					password = SerialNumGenerator.generator(6);
//					System.out.println(password);
					mb.setM_Password(AES.encrypt(password));
					// 修改密碼
					if (mDAO.updatePassword(mb) == null) {

						// 寄信
						String from = "java004no1@gmail.com";
						List<String> to = Arrays.asList(new String[] { checkEmail, "java004no1@gmail.com" });

						String subject = "會員找回密碼";
						String text = "<h1>謝謝您使用找回密碼的功能</h1>"
								+ "<h2>您的會員帳號 " + checkEmail + "</h2>" 			
								+ "<h2>您的會員密碼 "+ password + "</h2>" 
								+ "<h2>請您登入會員再次修改密碼</h2>"
								+ "<a href='http://localhost:8080/java004/WebShop/login_and_register.jsp"
								+ "'>會員管理</a><br>" + "<br><br><font color='blue'> 再次感謝, </font><br>Java004NO1工作小組敬上";

						JavaMailUtil util = new JavaMailUtil(from, to, subject, text);
						if (util.send()) {
							System.out.println("找回密碼發信成功");
						} else {
							System.out.println("找回密碼發信失敗");
						}
					}

				} else if (password == null) {
					errorMsg.add("驗證失敗");
				}
				// String s = "搜尋"+checkEmail+"的密碼成功";
				// toJson = new Gson().toJson(s);
			}

			out.println(toJson);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
