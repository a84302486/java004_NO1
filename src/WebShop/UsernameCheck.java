package WebShop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/WebShop/usernameCheck.do")
public class UsernameCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		MemberDAO rs = new MemberDAO();
		String M_Username = request.getParameter("member_Username");		
		System.out.println("收到Username = "+M_Username);
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		String toJson = null;
		
		try (PrintWriter out = response.getWriter();) {
			if (M_Username == null || M_Username.trim().length() == 0) {
				
				toJson = null;
				
			} else {
				if(rs.ifExist(M_Username)){ 
					toJson = "exist"; //已存在
				}else{
					toJson = "usable";  //可使用
				}
			}
		
			System.out.println(toJson);
			out.println(toJson);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}