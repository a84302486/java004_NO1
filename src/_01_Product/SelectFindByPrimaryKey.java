package _01_Product;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_01_Product/SelectFindByPrimaryKey.do")
public class SelectFindByPrimaryKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	ProductDAO pd = new ProductDAO();
    	String product_id = request.getParameter("productId");
    	Collection<ProductBean> coll = pd.findByPrimaryKey(product_id);

    	System.out.println("產品序號: "+ product_id);
    	
    	request.setAttribute("productId", product_id);
    	request.setAttribute("productIdColl", coll);
    	
    	if(product_id !=null && coll !=null){
    		RequestDispatcher rd = request.getRequestDispatcher("SelectSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("SelectError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   