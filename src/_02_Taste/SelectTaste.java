package _02_Taste;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;



@WebServlet("/_02_Taste/SelectTaste.do")
public class SelectTaste extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static boolean isInteger(String value) {
		Pattern pattern = Pattern.compile("^[-+]?\\d+$");
		return pattern.matcher(value).matches();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

	
		request.setCharacterEncoding("UTF-8");
		
		TasteDAO td= new TasteDAO();
		String tasteIdStr = request.getParameter("tasteId");
		Collection<TasteBean> coll = null;
		response.setContentType("application/json; charset=UTF-8");
		
		try (PrintWriter out = response.getWriter();) {
			if (tasteIdStr == null || tasteIdStr.trim().length() == 0) {
				System.out.println("判定為null");
				coll = td.findAll();	
			} else if (!isInteger(tasteIdStr)) {
				// errorMsg.add("必須是整數");
				System.out.println("必須是整數");
			}else {
				coll = td.findByPrimaryKey(tasteIdStr);
			}	
			String toJson = new Gson().toJson(coll);
			out.println(toJson);
		}
	}
}