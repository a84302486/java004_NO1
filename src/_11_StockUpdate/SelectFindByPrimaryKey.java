package _11_StockUpdate;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_11_StockUpdate/SelectFindByPrimaryKey.do")
public class SelectFindByPrimaryKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	String cpIdStr = request.getParameter("cpId");
    	Collection<StockUpdateBean> coll =  new StockUpdateDAO().findByPrimaryKey(cpIdStr);
 
    	System.out.println("序號: "+ cpIdStr);
    	
    	request.setAttribute("cpId", cpIdStr);
    	request.setAttribute("cpIdColl", coll);
    	
    	if(cpIdStr.trim().length()!=0 && !coll.isEmpty()){
    		RequestDispatcher rd = request.getRequestDispatcher("SelectSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("SelectError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   