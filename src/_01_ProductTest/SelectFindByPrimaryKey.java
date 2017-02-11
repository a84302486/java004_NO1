package _01_ProductTest;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_01_ProductTest/SelectFindByPrimaryKey")
public class SelectFindByPrimaryKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
		doPost(request, response);
	}
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	ProductDAO pd = new ProductDAO();
    	String productIdStr = request.getParameter("productId");
    	Collection<ProductBean> coll = pd.findByPrimaryKey(productIdStr);

    	System.out.println("產品序號: "+ productIdStr);
    	
    	request.setAttribute("productId", productIdStr);
    	request.setAttribute("productIdColl", coll);
    	
    	if(productIdStr !=null && coll !=null){
    		RequestDispatcher rd = request.getRequestDispatcher("SelectSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("SelectError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   