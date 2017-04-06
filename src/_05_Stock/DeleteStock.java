package _05_Stock;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/_05_Stock/DeleteStock.do")
public class DeleteStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
    	
		String stockIdStr = request.getParameter("stockId");   	   	
		Collection<String> coll = new ArrayList<>();
    	
    	if (stockIdStr == null || stockIdStr.trim().length() == 0) {
			coll.add("欄位必須輸入序號");
	
		} else {
			
			boolean success = new StockDAO().delete(stockIdStr);
			System.out.println("刪除產品序號"+ stockIdStr +"資料");

			if (success == true) {
				coll.add(("資料 "+stockIdStr+"刪除成功"));
				
			} else {
				coll.add(("資料 "+stockIdStr+"刪除失敗"));
			}
		}
		try (PrintWriter out = response.getWriter();) {

			String toJson = new Gson().toJson(coll);
			System.out.println(toJson);
			out.println(toJson);
		}

	}
}