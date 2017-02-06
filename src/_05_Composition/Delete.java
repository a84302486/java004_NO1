package _05_Composition;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_05_Composition/Delete.do")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	String compositionIdStr = request.getParameter("compositionId");
    	boolean success = new CompositionDAO().delete(compositionIdStr);
    	System.out.println("刪除成份資料: "+ compositionIdStr);
    	
    	request.setAttribute("compositionId", compositionIdStr);
    	
    	if(success == true){
    		RequestDispatcher rd = request.getRequestDispatcher("DeleteSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("DeleteError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   