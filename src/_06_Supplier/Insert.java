package _06_Supplier;


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

@WebServlet("/_06_Supplier/Insert.do")

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
			String supplierIdStr = request.getParameter("supplierId");
			if(supplierIdStr ==null || supplierIdStr.trim().length()==0){
				errorMsg.add("序號必須輸入");
			}else if(!isInteger(supplierIdStr)){
				errorMsg.add("序號必須是整數數字");
			}
			
			String nameStr = request.getParameter("name");
			if(nameStr ==null || nameStr.trim().length()==0)
				errorMsg.add("名稱必須輸入");
			
			String telephoneStr = request.getParameter("telephone");
			if(telephoneStr ==null || telephoneStr.trim().length()==0){
				errorMsg.add("電話號碼必須輸入");
			}else if(!isInteger(telephoneStr)){
				errorMsg.add("電話號碼必須是數字");
			}
			
			String zipNoStr = request.getParameter("zipNo");
			if(zipNoStr ==null || zipNoStr.trim().length()==0){
				errorMsg.add("郵遞區號必須輸入");
			}else if(!isInteger(zipNoStr)){
				errorMsg.add("郵遞區號必須是數字");
			}
			
			String addressStr = request.getParameter("address");
			if(addressStr ==null || addressStr.trim().length()==0)
				errorMsg.add("地址必須輸入");
				
			String faxStr = request.getParameter("fax");
			String emailStr = request.getParameter("email");
			String urlStr = request.getParameter("url");
			String principalNameStr = request.getParameter("principalName");
			String contactNameStr = request.getParameter("contactName");
			
			//若錯誤訊息不是空的,跳到此頁面
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
				rd.forward(request, response);
				return;
			}
			 
			String insertError = null;
			try{
				SupplierBean cb = new SupplierBean(supplierIdStr, nameStr, telephoneStr, zipNoStr, 
						addressStr, faxStr, emailStr, urlStr, principalNameStr, contactNameStr);
				
				insertError = new SupplierDAO().insert(cb);
			}catch(Exception e){
				errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
				e.printStackTrace();
			}
			if (insertError != null) {
				errorMsg.add(insertError);
			}
			
			// 依照 Business Logic 運算結果來挑選適當的畫面
			request.setAttribute("supplierId", supplierIdStr);
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
