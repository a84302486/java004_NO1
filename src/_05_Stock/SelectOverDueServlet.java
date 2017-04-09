package _05_Stock;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

@WebServlet("/_05_Stock/SelectOverDueServlet.do")

public class SelectOverDueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		
		Collection<StockBean> list = null;
		
		try (OutputStream os = response.getOutputStream();) {
			
			list = new StockDAO().findEXPOverDue();
			// listToJson寫出純文字資料
			String listToJson = new Gson().toJson(list);
			os.write(listToJson.getBytes("UTF-8"));
			System.out.println(listToJson);
		}
	}	
}