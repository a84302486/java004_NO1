package _07_Customer;
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



@WebServlet("/_07_Customer/SelectFindByPrimaryKey.do")
public class SelectFindByPrimaryKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	CustomerDAO rs = new CustomerDAO();
    	String M_Username = request.getParameter("Username");
    	String M_Name = rs.findByPrimaryKey(M_Username);
    	
    	System.out.println("帳號: "+M_Username);
    	System.out.println("姓名: "+M_Name);
    	
    	request.setAttribute("M_Username", M_Username);
    	request.setAttribute("M_Name", M_Name);
    	
    	if(M_Name!=null){
    		RequestDispatcher rd = request.getRequestDispatcher("SelectSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("SelectError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   