package _10_Warehouse;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_10_Warehouse/Delete.do")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	String wIdStr = request.getParameter("wId");
    	boolean success = new WarehouseDAO().delete(wIdStr);
    	System.out.println("刪除倉庫資料: "+wIdStr);
    	
    	request.setAttribute("wId", wIdStr);
    	
    	if(success == true){
    		RequestDispatcher rd = request.getRequestDispatcher("DeleteSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("DeleteError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   