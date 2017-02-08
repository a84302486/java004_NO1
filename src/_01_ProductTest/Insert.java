package _01_ProductTest;

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

@WebServlet("/_01_ProductTest/Insert.do")

public class Insert extends HttpServlet {
		private static final long serialVersionUID = 1L;

		public void doPost(HttpServletRequest request, HttpServletResponse response)
				throws IOException, ServletException {
			request.setCharacterEncoding("UTF-8");
			
			// 準備存放錯誤訊息的 List 物件
			List<String> errorMsg = new ArrayList<String>();
			// 傳送錯誤訊息的 List物件至JSP
			request.setAttribute("ErrorMsgKey", errorMsg);
			// 讀取輸入的資料 , 檢查輸入的資料
			
			String productIdStr = request.getParameter("productId");
			if(productIdStr ==null || productIdStr.trim().length()==0)
			{
				errorMsg.add("序號必須輸入");
			}
			else if(!isInteger(productIdStr))
			{
				errorMsg.add("序號必須是整數");
			}
			
			String PGPriceStr = request.getParameter("PGPrice");
			int PGPrice = 
					0;
			if(PGPriceStr ==null || PGPriceStr.trim().length()==0)
			{
				errorMsg.add("定價必須輸入");
			}
			else if(!isInteger(PGPriceStr))
			{
				errorMsg.add("定價必須是整數");
			}
			else
			{
				PGPrice = Integer.parseInt(PGPriceStr);
			}		
			
			String name = request.getParameter("name");
			if(name ==null || name.trim().length()==0)
				errorMsg.add("產品名稱必須輸入");
			
			String avgCostStr = request.getParameter("avgCost");
			double avgCost = 0;
			if(avgCostStr ==null || avgCostStr.trim().length()==0)
			{
				errorMsg.add("成本必須輸入");
			}
			else if(!isDouble(avgCostStr))
			{
				errorMsg.add("成本必須是小數");
			}
			else
			{
			    avgCost = Double.parseDouble(avgCostStr);
			}
			
			String oPlaceStr = request.getParameter("oPlace");
			if(oPlaceStr ==null || oPlaceStr.trim().length()==0)
				errorMsg.add("生產地必須輸入");
			
			String sLifeStr = request.getParameter("sLife");
			int sLife = 0;
			if(sLifeStr ==null || sLifeStr.trim().length()==0)
			{
				errorMsg.add("保存期必須輸入");
			}
			else if(!isInteger(sLifeStr))
			{
				errorMsg.add("保存期必須是整數");
			}
			else
			{
				 sLife = Integer.parseInt(sLifeStr);
			}
			
			String suppierIdStr = request.getParameter("suppierId");
			if(suppierIdStr ==null || suppierIdStr.trim().length()==0)
				errorMsg.add("供應商必須輸入");
			
			//若錯誤訊息不是空的,跳到此頁面
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
				rd.forward(request, response);
				return;
			}
		
			String insertError = null;
			try{
				ProductBean pb = new ProductBean(productIdStr, PGPrice, name, 
						avgCost, oPlaceStr, sLife, suppierIdStr);
				insertError = new ProductDAO().insert(pb);
			}catch(Exception e){
				errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
				e.printStackTrace();
			}
			if (insertError != null) {
				errorMsg.add(insertError);
			}
			// 依照 Business Logic 運算結果來挑選適當的畫面
			request.setAttribute("Product_id", productIdStr);
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
