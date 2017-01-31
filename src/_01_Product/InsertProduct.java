package _01_Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _00_Util.BeanDAO;

@WebServlet("/_01_Product/InsertProduct.do")

public class InsertProduct extends HttpServlet {
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
			String productId = request.getParameter("productId");
			String PGPrice = request.getParameter("PGPrice");
			String name = request.getParameter("name");
			String avgCost = request.getParameter("avgCost");
			String oPlace = request.getParameter("oPlace");
			String sLife = request.getParameter("sLife");
			String suppierId = request.getParameter("suppierId");
			// 檢查輸入的資料
			if(productId ==null || productId.trim().length()==0)
				errorMsg.add("序號必須輸入");
			
			if(PGPrice ==null || PGPrice.trim().length()==0)
				errorMsg.add("定價必須輸入");
			
			if(name ==null || name.trim().length()==0)
				errorMsg.add("產品名稱必須輸入");
			
			if(avgCost ==null || avgCost.trim().length()==0)
				errorMsg.add("成本必須輸入");
			
			if(oPlace ==null || oPlace.trim().length()==0)
				errorMsg.add("生產地必須輸入");
			
			if(sLife ==null || sLife.trim().length()==0)
				errorMsg.add("保存期必須輸入");
			
			if(suppierId ==null || suppierId.trim().length()==0)
				errorMsg.add("供應商必須輸入");
			//若錯誤訊息不是空的,跳到此頁面
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
				rd.forward(request, response);
				return;
			}
			 
			String insertError = null;
			
			try{
				ProductBean pb = new ProductBean(productId, PGPrice, name, 
						avgCost, oPlace, sLife, suppierId);
				insertError = new BeanDAO().insert(pb);
			}catch(Exception e){
				errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
				e.printStackTrace();
			}
			if (insertError != null) {
				errorMsg.add(insertError);
			}
			// 依照 Business Logic 運算結果來挑選適當的畫面
			request.setAttribute("Product_id", productId);
			if(errorMsg.isEmpty()){
				RequestDispatcher rd =request.getRequestDispatcher("InsertSuccess");
				rd.forward(request, response);
				return;
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("InsertError.jsp");
				rd.forward(request, response);
				return;
			}
		}
	}
}