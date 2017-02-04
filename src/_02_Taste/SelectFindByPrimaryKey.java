package _02_Taste;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_02_Taste/SelectFindByPrimaryKey.do")
public class SelectFindByPrimaryKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	String taste_id = request.getParameter("tasteId");
    	Collection<TasteBean> coll =  new TasteDAO().findByPrimaryKey(taste_id);
 
    	System.out.println("口味序號: "+ taste_id);
    	
    	request.setAttribute("tasteId", taste_id);
    	request.setAttribute("tasteIdColl", coll);
    	
    	if(taste_id.trim().length()!=0 && !coll.isEmpty()){
    		RequestDispatcher rd = request.getRequestDispatcher("SelectSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("SelectError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   