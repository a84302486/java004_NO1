package _14_Member;
import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_14_Member/SelectFindAll.do")
public class SelectFindAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		RegisterService rs = new RegisterService();
		Collection<MemberBean> coll = rs.findAll();
		
		request.setAttribute("memberColl", coll);
		RequestDispatcher rd = request.getRequestDispatcher("SelectAll.jsp");
		rd.forward(request, response);

	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}  