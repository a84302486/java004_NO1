package _14_Member;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



@WebServlet("/_14_Member/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		MemberDAO rs = new MemberDAO();
		String M_Username = request.getParameter("Username");
		System.out.println("收到Username = "+M_Username);
		
		Collection<MemberBean> coll = null;
		Collection<ResultBean> coll2 = new ArrayList<>();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");
		String toJson = null;
		String notFind = null; 
		try (PrintWriter out = response.getWriter();) {
			if (M_Username == null || M_Username.trim().length() == 0) {
				
				coll = rs.select();
				
			} else if(rs.ifExist(M_Username)){ 
				
				coll = rs.select(M_Username);
			}
			else {
				
				notFind = new Gson().toJson(coll2.add(new ResultBean(M_Username+" couldn't find.")));
				System.out.println(notFind);
			}
			//String test = "[{"+"&quot;"+"M_ID"+"&quot;"+":"+"&quot;"+"10012}]";
			toJson = new Gson().toJson(coll) +notFind;
			System.out.println(toJson);
			out.println(toJson);
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}