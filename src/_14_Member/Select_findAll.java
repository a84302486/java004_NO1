package _14_Member;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_14_Member/Select_findAll.do")
public class Select_findAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		RegisterService rs = new RegisterService();
		List<Member> list = rs.findAll();

//		for(int i=0;i<list.size();i++){
//			Member mb = list.get(i);
//			request.setAttribute("mb", mb);
//		}
		
		request.setAttribute("mb", list);
		RequestDispatcher rd = request.getRequestDispatcher("select_all.jsp");
		rd.forward(request, response);

	}

}  