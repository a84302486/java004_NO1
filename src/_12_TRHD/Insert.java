package _12_TRHD;


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

@WebServlet("/_13_TRDT/Insert.do")

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
			String supplierId = request.getParameter("supplierId");
			if(supplierId ==null || supplierId.trim().length()==0){
				errorMsg.add("序號必須輸入");
			}else if(!isInteger(supplierId)){
				errorMsg.add("序號必須是整數數字");
			}
			
			String name = request.getParameter("name");
			if(name ==null || name.trim().length()==0)
				errorMsg.add("名稱必須輸入");
			
			String telephone = request.getParameter("telephone");
			if(telephone ==null || telephone.trim().length()==0){
				errorMsg.add("電話號碼必須輸入");
			}else if(!isInteger(telephone)){
				errorMsg.add("電話號碼必須是數字");
			}
			
			String zipNo = request.getParameter("zipNo");
			if(telephone ==null || telephone.trim().length()==0){
				errorMsg.add("郵遞區號必須輸入");
			}else if(!isInteger(telephone)){
				errorMsg.add("郵遞區號必須是數字");
			}
			
			String address = request.getParameter("address");
			if(address ==null || address.trim().length()==0)
				errorMsg.add("地址必須輸入");
				
			String fax = request.getParameter("fax");
			String email = request.getParameter("email");
			String url = request.getParameter("url");
			String principal_Name = request.getParameter("principal_Name");
			String contact_Name = request.getParameter("contact_Name");
			
			//若錯誤訊息不是空的,跳到此頁面
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
				rd.forward(request, response);
				return;
			}
			 
			String insertError = null;
			try{
				TRHDBean cb = new TRHDBean();
//				insertError = new TRDTBean().insert(cb);
			}catch(Exception e){
				errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
				e.printStackTrace();
			}
			if (insertError != null) {
				errorMsg.add(insertError);
			}
			
			// 依照 Business Logic 運算結果來挑選適當的畫面
			request.setAttribute("supplier_Id", supplierId);
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
