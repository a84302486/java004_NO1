package WebShop;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_Util.AES;
import _14_Member.MemberBean;
import _14_Member.MemberDAO;

@WebServlet("/WebShop/LoginMember")
public class LoginMember extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// 準備存放錯誤訊息的 Map<String, String> 物件 : errorMsgMap
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		// 將 errorMsgMap 放入 request 置物櫃內，識別字串為 "ErrorMsgKey"
		request.setAttribute("ErrorMsgKey", errorMsgMap);
		// 1. 讀取使用者輸入資料(<Input>標籤內的name屬性分別為 userId與pswd
		String userId = request.getParameter("Username");
		String password = request.getParameter("Password");
		String remember = request.getParameter("remember");
		
		System.out.println("remember="+remember);
		
		
		// 3. 檢查使用者輸入資料
		// 如果 userId 欄位為空白，放錯誤訊息"帳號欄必須輸入"到 errorMsgMap 之內
		// 對應的識別字串為 "AccountEmptyError"
		if (userId == null || userId.trim().length() == 0) {
			errorMsgMap.put("AccountEmptyError", "帳號欄必須輸入");
		}
		// 如果 password 欄位為空白，放錯誤訊息"密碼欄必須輸入"到 errorMsgMap 之內
		// 對應的識別字串為 "PasswordEmptyError"
		if (password == null || password.trim().length() == 0) {
			errorMsgMap.put("PasswordEmptyError", "密碼欄必須輸入");
		}
		// 如果 errorMsgMap 不是空的，表示有錯誤，交棒給/ch06_01/login.jsp，
		// 然後 return
		if (!errorMsgMap.isEmpty()) {
			RequestDispatcher rd = request
					.getRequestDispatcher("/WebShop/login_and_register.jsp");
			rd.forward(request, response);
			return;
		}
		// 4. 進行 Business Logic 運算
		// 將LoginService類別new為物件，存放物件參考的變數為 ls
		MemberService ls = new MemberService();
		// 呼叫 ls物件的 checkIDPassword()，要記得傳入userid與password兩個參數
		// 同時將傳回值放入MemberBean型別的變數mb之內。

		MemberBean mb = null;

		try {
			mb = ls.checkIDPassword(userId, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 如果變數mb的值不等於 null,表示資料庫含有userId搭配password的紀錄
		if(mb == null){
			errorMsgMap.put("LoginError", "該帳號不存在或密碼錯誤");
		}else {
			if(!new MemberDAO().checkCertification(userId)){
				errorMsgMap.put("LoginError", "該帳號還沒有認證");
			}else{
				session.setAttribute("MemberLoginOK", mb);
				
				// 記住我---------------------------------------------------------------------
				
				if("true".equals(remember)){
					
					String host = request.getServerName();
					
					// 保存帳號到Cookie
					Cookie cookie = new Cookie("SESSION_LOGIN_USERNAME", userId); 
					cookie.setPath("/");
					cookie.setDomain(host);
					cookie.setMaxAge(60*60*24*30); //30天
					response.addCookie(cookie);
					
					// 保存密碼到Cookie
					password = AES.encrypt(password);//密碼加密
					cookie = new Cookie("SESSION_LOGIN_PASSWORD",password);
					cookie.setPath("/");
					cookie.setDomain(host);
					cookie.setMaxAge(60*60*24*30); //30天
					response.addCookie(cookie);
					
										
				}else{
					//remember=null
					
					Cookie[] cookies = request.getCookies();
					if (cookies != null) {
						
						try{
							for(int i=0;i<cookies.length;i++) {
							//System.out.println(cookies[i].getName() ":" cookies[i].getValue())；
								Cookie cookie = new Cookie(cookies[i].getName(), null);
								cookie.setMaxAge(0);
								cookie.setPath("/");
								response.addCookie(cookie);
							}
							
						}catch(Exception ex) {
								System.out.println("刪除cookies發生異常");
						}
						
					} 
					//找不到Cookie，沒事。
					
				}
			}
		}
		
		
				
		//---------------------------------------------------------------------------
		
		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		// 如果 errorMsgMap是空的，表示沒有任何錯誤，準備交棒給下一隻程式
		if (errorMsgMap.isEmpty()) {
			// 如果session物件內含有"target"屬性物件，表示使用者先前嘗試執行某個應該
			// 登入，但使用者未登入的網頁，由該網頁放置的"target"屬性物件，因此如果
			// 有"target"屬性物件則導向"target"屬性物件所標示的網頁，否則導向首頁
			String contextPath = getServletContext().getContextPath();
			String target = (String) session.getAttribute("target");
			if (target != null) {
				// 先由session中移除此項屬性，否則下一次User直接執行login功能後，
				// 會再度被導向到 target
				session.removeAttribute("target");
				// 導向 contextPath + target
				//response.sendRedirect(contextPath + target);
				response.sendRedirect(
			       response.encodeRedirectURL(contextPath + target));
				System.out.println("登入成功 轉往"+contextPath+target);

			} else {
				// 導向 contextPath + "/index.jsp"
				//response.sendRedirect(contextPath + "/index.jsp");
                response.sendRedirect(
			      response.encodeRedirectURL(contextPath + "/WebShop/memberManage.jsp" ));
                System.out.println("登入成功");
			}
			return;
		} else {
			// 如果 errorMsgMap 不是空的，表示有錯誤，交棒給/ch06_01/login.jsp
			RequestDispatcher rd = request
					.getRequestDispatcher("/WebShop/login_and_register.jsp");
			rd.forward(request, response);
			System.out.println("登入失敗");
			return;
		}
	}
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			
		doPost(request,response);
	}
}
