package _05_Composition;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/_05_Composition/SelectFindByPrimaryKey.do")
public class SelectFindByPrimaryKey extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException, ServletException {
    	
    	String composition_type = request.getParameter("compositionType");
    	Collection<CompositionBean> coll =  new CompositionDAO().findByPrimaryKey(composition_type);
 
    	System.out.println("成份類型: "+ composition_type);
    	
    	request.setAttribute("compositionType", composition_type);
    	request.setAttribute("compositionIdColl", coll);
    	
    	if(composition_type.trim().length()!=0 && !coll.isEmpty()){
    		RequestDispatcher rd = request.getRequestDispatcher("SelectSuccess.jsp");
    		rd.forward(request, response);
    	}else{
    		RequestDispatcher rd = request.getRequestDispatcher("SelectError.jsp");
    		rd.forward(request, response);		
    	}
    }
    	
}   