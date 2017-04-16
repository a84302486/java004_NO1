package WebShop;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_Util.AES;

//@WebFilter("/WebShop/login_and_register.jsp")
public class FindUserPassword implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		System.out.println("執行login_and_register.jsp前先執行本程式");
		
		if (request instanceof HttpServletRequest
				&& response instanceof HttpServletResponse) {
			HttpServletRequest req = (HttpServletRequest) request;
//			HttpServletResponse resp = (HttpServletResponse) response;
			HttpSession session = req.getSession();
			// **********Remember Me****************
			String username = "";
			String password = "";

			Cookie[] cookies = req.getCookies();

			if (cookies != null) {
				
				for (int i = 0; i < cookies.length; i++) {
					String cookieName = cookies[i].getName();
					if (cookieName.equals("SESSION_LOGIN_USERNAME")) {
					
						username = cookies[i].getValue();
						
//						System.out.println("username ="+username);
					} else if (cookieName.equals("SESSION_LOGIN_PASSWORD")) {
										
						String tmp  = cookies[i].getValue();
					
						if (tmp!= null){	
							password = 	AES.decrypt(tmp);					
						}
						
//						System.out.println("password ="+password);
					}
				}
			} else {
				// 找不到Cookie，沒事。
			}

//			session.setAttribute("username", username);
//			session.setAttribute("password", password);
		}
		chain.doFilter(request, response);
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}
	public void destroy() {		
	}

}
