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

@WebServlet("/_14_Member/Certification")
public class Certification extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		MemberDAO rs = new MemberDAO();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		String M_Username = request.getParameter("Username");
		System.out.println("M_Username="+M_Username);
		new MemberDAO().Certification(M_Username);
		
		response.setContentType("text/html; charset=utf-8");			
		RequestDispatcher rd =request.getRequestDispatcher("/WebShop/certificationSuccess.jsp");
		rd.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

}