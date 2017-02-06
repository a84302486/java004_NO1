package _02_Taste;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/_02_Taste/Insert.do")

public class Insert extends HttpServlet {
		private static final long serialVersionUID = 1L;

		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			request.setCharacterEncoding("UTF-8");
			
			// 準備存放錯誤訊息的 List 物件
			List<String> errorMsg = new ArrayList<String>();
			
			// 傳送錯誤訊息的 List物件至JSP
			request.setAttribute("ErrorMsgKey", errorMsg);
			
			// 讀取輸入的資料
			String tasteIdStr = request.getParameter("tasteId");
			if(tasteIdStr ==null || tasteIdStr.trim().length()==0){
				errorMsg.add("序號必須輸入");
			}
			
			String tasteNameStr = request.getParameter("tasteName");
			if(tasteNameStr ==null || tasteNameStr.trim().length()==0)
				errorMsg.add("名稱必須輸入");

			//若錯誤訊息不是空的,跳到此頁面
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
				rd.forward(request, response);
				return;
			}
			 
			String insertError = null;
			try{
				TasteBean tb = new TasteBean(tasteIdStr, tasteNameStr);
				insertError = new TasteDAO().insert(tb);
			}catch(Exception e){
				errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
				e.printStackTrace();
			}
			if (insertError != null) {
				errorMsg.add(insertError);
			}
			
			// 依照 Business Logic 運算結果來挑選適當的畫面
			request.setAttribute("TasteId", tasteIdStr);
			if(errorMsg.isEmpty()){
				RequestDispatcher rd =request.getRequestDispatcher("InsertSuccess.jsp");
				rd.forward(request, response);
				return;
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
				rd.forward(request, response);
				return;
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
