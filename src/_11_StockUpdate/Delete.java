package _11_StockUpdate;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_11_StockUpdate/Delete.do")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	String cpIdStr = request.getParameter("cpId");
    	boolean success = new StockUpdateDAO().delete(cpIdStr);
    	System.out.println("刪除倉庫資料: "+ cpIdStr);
    	
    	request.setAttribute("wId", cpIdStr);
    	
    	if(success == true){
    		RequestDispatcher rd = request.getRequestDispatcher("DeleteSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("DeleteError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   