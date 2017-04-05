package _14_Member;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/_14_Member/JavaMail")
public class JavaMailMain extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		String username = request.getParameter("Username");
		System.out.println("JavaMail收到 Username="+username);
		//發送認證信
		String from = "java004no1@gmail.com";
		List<String> to = Arrays.asList(
				   new String[]{username,"java004no1@gmail.com"});
	
		
		String subject = "歡迎加入會員";
		String text = 
		  "<h1>謝謝您加入會員</h1>" +
		  "<h2>您的會員帳號 "+username+"</h2>" +
		  "<h2>請您按下列連結完成註冊的認證</h2>" +
	      "<a href='http://localhost:8080/java004/_14_Member/Certification?Username="+username+"'>認證網址</a><br>" +
          "<br><br><font color='blue'> 再次感謝, </font><br>Java004NO1工作小組敬上";
		
		
		JavaMailUtil  util = new JavaMailUtil(from, to, subject, text );
		if (util.send()){
		   System.out.println("發信成功");
		} else {
		   System.out.println("發信失敗");
		}
		
		response.setContentType("text/html; charset=utf-8");			
		RequestDispatcher rd =request.getRequestDispatcher("/WebShop/registerSuccess.jsp");
		rd.forward(request, response);
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}


}
