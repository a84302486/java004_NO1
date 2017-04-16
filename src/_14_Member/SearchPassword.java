package _14_Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/_02_Taste/SearchPassword")

public class SearchPassword extends HttpServlet {
		private static final long serialVersionUID = 1L;

		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			request.setCharacterEncoding("UTF-8");
			
			// 準備存放錯誤訊息的 List 物件
			List<String> errorMsg = new ArrayList<String>();
			
			// 傳送錯誤訊息的 List物件至JSP
			request.setAttribute("ErrorMsgKey", errorMsg);
			
			// 讀取輸入的資料
			String checkEmail = request.getParameter("checkEmail");
			String checkBirthday = request.getParameter("checkBirthday");
			String checkPhoneNumber = request.getParameter("checkPhoneNumber");
			if(checkEmail ==null || checkEmail.trim().length()==0){
				errorMsg.add("帳號必須輸入");
			}
			if(checkBirthday ==null || checkBirthday.trim().length()==0){
				errorMsg.add("生日必須輸入");
			}else if(!isInteger(checkBirthday)){
				errorMsg.add("請填入數字數字");
			}

			if(checkPhoneNumber ==null || checkPhoneNumber.trim().length()==0){
				errorMsg.add("電話號碼必須輸入");
			}else if(!isInteger(checkPhoneNumber)){
				errorMsg.add("請填入數字數字");
			}
							 
			try (PrintWriter out = response.getWriter();) {

				String toJson = null;

				if (!errorMsg.isEmpty()) {
					toJson = new Gson().toJson(errorMsg);
				} else {
					new MemberDAO().getPassword(checkEmail,checkBirthday,checkPhoneNumber);
					String s = "搜尋"+checkEmail+"密碼成功";
					toJson = new Gson().toJson(s);
				}

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
