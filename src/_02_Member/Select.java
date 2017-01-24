package _02_Member;
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



@WebServlet("/_02_Member/select.do")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	RegisterService rs = new RegisterService();
    	String M_Username = request.getParameter("Username");
    	String M_Name = rs.findByPrimaryKey(M_Username);
    	
    	RequestDispatcher rd = request.getRequestDispatcher("findPrimaryKey.jsp");
		rd.forward(request, response);
    }
    	
}   