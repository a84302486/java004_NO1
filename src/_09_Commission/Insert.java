package _09_Commission;


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

@WebServlet("/_09_Commission/Insert.do")

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
			String commissionIdStr = request.getParameter("commissionId");
			int commissionId = 0;
			if(!isInteger(commissionIdStr)){
				errorMsg.add("序號必須是整數");
			}else{
				commissionId = Integer.parseInt(commissionIdStr);
			}
			
			String customerIdStr = request.getParameter("customerId");
			if(!isInteger(customerIdStr)){
				errorMsg.add("客戶Id必須是整數");
			}
			
			String discount01Str = request.getParameter("discount01");
			double discount01 = 0;
			if(!isDouble(discount01Str)){
				errorMsg.add("折扣序號必須是整數");
			}else{
				discount01 = Double.parseDouble(discount01Str);
			}
			
			String discount02Str = request.getParameter("discount02");
			double discount02 = 0;
			if(!isDouble(discount02Str)){
				errorMsg.add("折扣序號必須是整數");
			}else{
				discount02 = Double.parseDouble(discount02Str);
			}
			
			String discount03Str = request.getParameter("discount03");
			double discount03 = 0;
			if(!isDouble(discount03Str)){
				errorMsg.add("折扣序號必須是整數");
			}else{
				discount03 = Double.parseDouble(discount03Str);
			}
			
			String discount04Str = request.getParameter("discount04");
			double discount04 = 0;
			if(!isDouble(discount04Str)){
				errorMsg.add("折扣序號必須是整數");
			}else{
				discount04 = Double.parseDouble(discount04Str);
			}
			
			String discount05Str = request.getParameter("discount05");
			double discount05 = 0;
			if(!isDouble(discount05Str)){
				errorMsg.add("折扣序號必須是整數");
			}else{
				discount05 = Double.parseDouble(discount05Str);
			}
			
			String discount06Str = request.getParameter("discount06");
			double discount06 = 0;
			if(!isDouble(discount06Str)){
				errorMsg.add("折扣序號必須是整數");
			}else{
				discount06 = Double.parseDouble(discount06Str);
			}
			
			String discount07Str = request.getParameter("discount07");
			double discount07 = 0;
			if(!isDouble(discount07Str)){
				errorMsg.add("折扣序號必須是整數");
			}else{
				discount07 = Double.parseDouble(discount07Str);
			}
			
			String discount08Str = request.getParameter("discount08");
			double discount08 = 0;
			if(!isDouble(discount08Str)){
				errorMsg.add("折扣序號必須是整數");
			}else{
				discount08 = Double.parseDouble(discount08Str);
			}
			
			String discount09Str = request.getParameter("discount09");
			double discount09 = 0;
			if(!isDouble(discount09Str)){
				errorMsg.add("折扣序號必須是整數");
			}else{
				discount09 = Double.parseDouble(discount09Str);
			}
			
			String discount10Str = request.getParameter("discountId10");
			double discount10 = 0;
			if(!isDouble(discount10Str)){
				errorMsg.add("折扣序號必須是整數");
			}else{
				discount10 = Double.parseDouble(discount10Str);
			}
			
			
			String rate01Str = request.getParameter("rate01");
			double rate01 = 0;
			if(!isDouble(rate01Str)){
				errorMsg.add("Rate必須是整數加小數點");
			}else{
				rate01 = Double.parseDouble(rate01Str);
			}
			
			String rate02Str = request.getParameter("rate02");
			double rate02 = 0;
			if(!isDouble(rate01Str)){
				errorMsg.add("Rate必須是整數加小數點");
			}else{
				rate02 = Double.parseDouble(rate02Str);
			}
			
			String rate03Str = request.getParameter("rate03");
			double rate03 = 0;
			if(!isDouble(rate03Str)){
				errorMsg.add("Rate必須是整數加小數點");
			}else{
				rate03 = Double.parseDouble(rate03Str);
			}
			
			String rate04Str = request.getParameter("rate04");
			double rate04 = 0;
			if(!isDouble(rate01Str)){
				errorMsg.add("Rate必須是整數加小數點");
			}else{
				rate04 = Double.parseDouble(rate04Str);
			}
			
			String rate05Str = request.getParameter("rate05");
			double rate05 = 0;
			if(!isDouble(rate05Str)){
				errorMsg.add("Rate必須是整數加小數點");
			}else{
				rate05 = Double.parseDouble(rate05Str);
			}
			
			String rate06Str = request.getParameter("rate06");
			double rate06 = 0;
			if(!isDouble(rate06Str)){
				errorMsg.add("Rate必須是整數加小數點");
			}else{
				rate06 = Double.parseDouble(rate06Str);
			}
			
			String rate07Str = request.getParameter("rate07");
			double rate07 = 0;
			if(!isDouble(rate07Str)){
				errorMsg.add("Rate必須是整數加小數點");
			}else{
				rate07 = Double.parseDouble(rate07Str);
			}
			
			String rate08Str = request.getParameter("rate08");
			double rate08 = 0;
			if(!isDouble(rate08Str)){
				errorMsg.add("Rate必須是整數加小數點");
			}else{
				rate08 = Double.parseDouble(rate08Str);
			}
			
			String rate09Str = request.getParameter("rate09");
			double rate09 = 0;
			if(!isDouble(rate09Str)){
				errorMsg.add("Rate必須是整數加小數點");
			}else{
				rate09 = Double.parseDouble(rate09Str);
			}
			
			String rate10Str = request.getParameter("rate10");
			double rate10 = 0;
			if(!isDouble(rate10Str)){
				errorMsg.add("Rate必須是整數加小數點");
			}else{
				rate10 = Double.parseDouble(rate10Str);
			}
			
			
			
			//若錯誤訊息不是空的,跳到此頁面
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
				rd.forward(request, response);
				return;
			}
			 
			String insertError = null;
			try{
				CommissionBean cb = new CommissionBean(commissionId, customerIdStr, discount01, discount02, discount03, 
						discount04, discount05, discount06, discount07, discount08, discount09, discount10, 
						rate01, rate02, rate03, rate04, rate05, rate06, rate07, rate08, rate09, rate10);
				insertError = new CommissionDAO().insert(cb);
			}catch(Exception e){
				errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
				e.printStackTrace();
			}
			if (insertError != null) {
				errorMsg.add(insertError);
			}
			
			// 依照 Business Logic 運算結果來挑選適當的畫面
			request.setAttribute("commissionId", commissionIdStr);
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
