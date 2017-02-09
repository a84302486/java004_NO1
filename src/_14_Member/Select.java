package _14_Member;
import java.io.File;
import java.io.IOException;
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

import _07_Customer.CustomerBean;



@WebServlet("/_14_Member/Select.do")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	MemberDAO rs = new MemberDAO();
    	String M_Username = request.getParameter("Username");
    	
    	if(M_Username == null || M_Username.trim().length() == 0){
    		
    		Collection<MemberBean> coll = rs.findAll(); 		
    		request.setAttribute("memberColl", coll);
    		RequestDispatcher rd = request.getRequestDispatcher("SelectAll.jsp");
    		rd.forward(request, response);
    		
    	}else{
    		Collection<MemberBean> coll= rs.findByPrimaryKey(M_Username);
    		request.setAttribute("memberColl", coll);
    		RequestDispatcher rd = request.getRequestDispatcher("SelectAll.jsp");
    		rd.forward(request, response);
    	}
    	   	
    }
    
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
    	
}   