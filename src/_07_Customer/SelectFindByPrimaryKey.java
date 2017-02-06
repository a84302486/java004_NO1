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
    	String CustomeridStr = request.getParameter("CustomerId");
    	String NameStr = rs.findByPrimaryKey(CustomeridStr);
    	
    	System.out.println("編號: "+ CustomeridStr);
    	System.out.println("名稱: "+ NameStr);
    	
    	request.setAttribute("Customer_id", CustomeridStr);
    	request.setAttribute("Name", NameStr);
    	
    	if(NameStr!=null){
    		RequestDispatcher rd = request.getRequestDispatcher("SelectSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("SelectError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   