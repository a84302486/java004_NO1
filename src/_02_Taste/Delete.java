package _02_Taste;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_02_Taste/Delete.do")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	String tasteId = request.getParameter("tasteId");
    	boolean success = new TasteDAO().delete(tasteId);
    	System.out.println("刪除口味資料: "+tasteId);
    	
    	request.setAttribute("productId", tasteId);
    	
    	if(success == true){
    		RequestDispatcher rd = request.getRequestDispatcher("DeleteSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("DeleteError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   