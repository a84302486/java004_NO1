package _10_Warehouse;


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

@WebServlet("/_10_Warehouse/Insert.do")

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
			String wIdStr = request.getParameter("wId");
			int wId = 0;
			if(wIdStr ==null || wIdStr.trim().length()==0){
				errorMsg.add("序號必須輸入");
			}else if(!isInteger(wIdStr)){
				errorMsg.add("序號必須是整數數字");
			}else{
				wId = Integer.parseInt(wIdStr);
			}		
			
			String customerIdStr = request.getParameter("customerId");
			if(customerIdStr ==null || customerIdStr.trim().length()==0)
				errorMsg.add("客戶名稱必須輸入");
			
			String productIdStr = request.getParameter("productId");
			if(productIdStr ==null || productIdStr.trim().length()==0)
				errorMsg.add("產品名稱必須輸入");
			
			String tasteIdStr = request.getParameter("tasteId");
			if(tasteIdStr ==null || tasteIdStr.trim().length()==0)
				errorMsg.add("口味必須輸入");
			
			String packageIdStr = request.getParameter("packageId");
			if(packageIdStr ==null || packageIdStr.trim().length()==0)
				errorMsg.add("包裝必須輸入");
			
			String stockStr = request.getParameter("stock");
			int stock = 0;
			if(stockStr ==null || stockStr.trim().length()==0){
				errorMsg.add("庫存必須輸入");
			}else if(!isInteger(stockStr)){
				errorMsg.add("庫存必須是整數數字");
			}else{
				stock = Integer.parseInt(stockStr);
			}
			
			String acRECStr = request.getParameter("acREC");
			int acREC = 0;
			if(acRECStr ==null || acRECStr.trim().length()==0){
				errorMsg.add("AC_REC必須輸入");
			}else if(!isInteger(acRECStr)){
				errorMsg.add("AC_REC必須是整數數字");
			}else{
				acREC = Integer.parseInt(acRECStr);
			}
			
			String acRETStr = request.getParameter("acRET");
			int acRET = 0;
			if(acRETStr ==null || acRETStr.trim().length()==0){
				errorMsg.add("AC_RET必須輸入");
			}else if(!isInteger(acRECStr)){
				errorMsg.add("AC_RET必須是整數數字");
			}else{
				acRET = Integer.parseInt(acRETStr);
			}
			
			String acSALStr = request.getParameter("acSAL");
			int acSAL = 0;
			if(acSALStr ==null || acSALStr.trim().length()==0){
				errorMsg.add("AC_SAL必須輸入");
			}else if(!isInteger(acRECStr)){
				errorMsg.add("AC_SAL必須是整數數字");
			}else{
				acSAL = Integer.parseInt(acSALStr);
			}
			
			String acBADStr = request.getParameter("acBAD");
			int acBAD = 0;
			if(acBADStr ==null || acBADStr.trim().length()==0){
				errorMsg.add("AC_BAD必須輸入");
			}else if(!isInteger(acBADStr)){
				errorMsg.add("AC_BAD必須是整數數字");
			}else{
				acBAD = Integer.parseInt(acBADStr);
			}
			
			String acBALStr = request.getParameter("acBAL");
			int acBAL = 0;
			if(acBALStr ==null || acBALStr.trim().length()==0){
				errorMsg.add("AC_BAL必須輸入");
			}else if(!isInteger(acBALStr)){
				errorMsg.add("AC_BAL必須是整數數字");
			}else{
				acBAL = Integer.parseInt(acBALStr);
			}
			
			String mfdStr = request.getParameter("mfd");


			//若錯誤訊息不是空的,跳到此頁面
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
				rd.forward(request, response);
				return;
			}
			 
			String insertError = null;
			try{
				WarehouseBean cb = new WarehouseBean(wId, customerIdStr, productIdStr, tasteIdStr, packageIdStr, 
						stock, acREC, acRET, acSAL, acBAD, acBAL, mfdStr);
				insertError = new WarehouseDAO().insert(cb);
			}catch(Exception e){
				errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
				e.printStackTrace();
			}
			if (insertError != null) {
				errorMsg.add(insertError);
			}
			
			// 依照 Business Logic 運算結果來挑選適當的畫面
			request.setAttribute("wId", wId);
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
