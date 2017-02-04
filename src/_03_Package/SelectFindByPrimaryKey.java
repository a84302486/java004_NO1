package _03_Package;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_03_Package/SelectFindByPrimaryKey.do")
public class SelectFindByPrimaryKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	String package_id = request.getParameter("packageId");
    	Collection<PackageBean> coll =  new PackageDAO().findByPrimaryKey(package_id);
 
    	System.out.println("包裝序號: "+ package_id);
    	
    	request.setAttribute("packageId", package_id);
    	request.setAttribute("packageIdColl", coll);
    	
    	if(package_id.trim().length()!=0 && !coll.isEmpty()){
    		RequestDispatcher rd = request.getRequestDispatcher("SelectSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("SelectError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   