package _08_Discount;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_08_Discount/SelectFindByPrimaryKey.do")
public class SelectFindByPrimaryKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	String discountIdStr = request.getParameter("discountId");
    	Collection<DiscountBean> coll =  new DiscountDAO().findByPrimaryKey(discountIdStr);
 
    	System.out.println("折扣序號: "+ discountIdStr);
    	
    	request.setAttribute("discountId", discountIdStr);
    	request.setAttribute("discountIdColl", coll);
    	
    	if(discountIdStr.trim().length()!=0 && !coll.isEmpty()){
    		RequestDispatcher rd = request.getRequestDispatcher("SelectSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("SelectError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   