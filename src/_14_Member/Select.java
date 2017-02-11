package _14_Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/_14_Member/Select.do")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");

		try (
				PrintWriter out = response.getWriter();
		) {
			MemberJDBC rs = new MemberJDBC();
			String M_Username = request.getParameter("Username");
			Collection<MemberBean> coll = null;
			
			if (M_Username == null || M_Username.trim().length() == 0) {

				 coll = rs.getAllMembers();
				//request.setAttribute("memberColl", coll);

			} else {
				
				coll = rs.getOneMember(M_Username);
				//request.setAttribute("memberColl", coll);

			}
			
			String categoriesJson = new Gson().toJson(coll);
			out.write(categoriesJson);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}  