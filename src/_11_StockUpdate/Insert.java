package _11_StockUpdate;


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

@WebServlet("/_11_StockUpdate/Insert.do")

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
//			String cpIdstr = request.getParameter("cpId");
			int cpId = 0;
			
			String cpDateStr = request.getParameter("cpDate");
			if(cpDateStr ==null || cpDateStr.trim().length()==0){
				errorMsg.add("日期必須輸入");
			}	
			
			String cpRECStr = request.getParameter("cpREC");
			int cpREC = 0;
			if(cpRECStr ==null || cpRECStr.trim().length()==0){
				errorMsg.add("REC必須輸入");
			}else if(!isInteger(cpRECStr)){
				errorMsg.add("序號必須是整數數字");
			}else{
				cpREC = Integer.parseInt(cpRECStr);
			}	
			
			String cpRETStr = request.getParameter("cpRET");
			int cpRET = 0;
			if(cpRETStr ==null || cpRETStr.trim().length()==0){
				errorMsg.add("RET必須輸入");
			}else if(!isInteger(cpRETStr)){
				errorMsg.add("序號必須是整數數字");
			}else{
				cpRET = Integer.parseInt(cpRETStr);
			}	
			
			String cpSALStr = request.getParameter("cpSAL");
			int cpSAL = 0;
			if(cpSALStr ==null || cpSALStr.trim().length()==0){
				errorMsg.add("SAL必須輸入");
			}else if(!isInteger(cpSALStr)){
				errorMsg.add("序號必須是整數數字");
			}else{
				cpSAL = Integer.parseInt(cpSALStr);
			}
			
			String cpBADStr = request.getParameter("cpBAD");
			int cpBAD = 0;
			if(cpBADStr ==null || cpBADStr.trim().length()==0){
				errorMsg.add("BAD必須輸入");
			}else if(!isInteger(cpBADStr)){
				errorMsg.add("序號必須是整數數字");
			}else{
				cpBAD = Integer.parseInt(cpBADStr);
			}
			
			String cpBALStr = request.getParameter("cpBAL");
			int cpBAL = 0;
			if(cpBALStr ==null || cpBALStr.trim().length()==0){
				errorMsg.add("BAL必須輸入");
			}else if(!isInteger(cpBALStr)){
				errorMsg.add("序號必須是整數數字");
			}else{
				cpBAL = Integer.parseInt(cpBALStr);
			}
			
			String endStockStr = request.getParameter("endStock");
			int endStock = 0;
			if(endStockStr ==null || endStockStr.trim().length()==0){
				errorMsg.add("結存必須輸入");
			}else if(!isInteger(endStockStr)){
				errorMsg.add("結存必須是整數數字");
			}else{
				endStock = Integer.parseInt(endStockStr);
			}
			
			String netStockStr = request.getParameter("netStock");
			int netStock = 0;
			if(netStockStr ==null || netStockStr.trim().length()==0){
				errorMsg.add("庫存必須輸入");
			}else if(!isInteger(netStockStr)){
				errorMsg.add("庫存必須是整數數字");
			}else{
				netStock = Integer.parseInt(netStockStr);
			}
			//若錯誤訊息不是空的,跳到此頁面
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
				rd.forward(request, response);
				return;
			}
			 
			String insertError = null;
			try{
				StockUpdateBean cb = new StockUpdateBean( cpDateStr, cpREC, cpRET, cpSAL, 
						cpBAD, cpBAL, endStock, netStock);
						
				insertError = new StockUpdateDAO().insert(cb);
			}catch(Exception e){
				errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
				e.printStackTrace();
			}
			if (insertError != null) {
				errorMsg.add(insertError);
			}
			
			// 依照 Business Logic 運算結果來挑選適當的畫面
			request.setAttribute("cpId", cpId);
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
