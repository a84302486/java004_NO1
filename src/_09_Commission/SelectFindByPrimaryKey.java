package _09_Commission;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_09_Commission/SelectFindByPrimaryKey.do")
public class SelectFindByPrimaryKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	String commissionIdStr = request.getParameter("commissionId");
    	Collection<CommissionBean> coll =  new CommissionDAO().findByPrimaryKey(commissionIdStr);
 
    	System.out.println("折扣序號: "+ commissionIdStr);
    	
    	request.setAttribute("commissionId", commissionIdStr);
    	request.setAttribute("commissionIdColl", coll);
    	
    	if(commissionIdStr.trim().length()!=0 && !coll.isEmpty()){
    		RequestDispatcher rd = request.getRequestDispatcher("SelectSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("SelectError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   