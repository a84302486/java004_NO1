package _14_Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import WebShop.MemberService;
import _00_Util.AES;

@WebServlet("/_14_Member/UpdatePassword")
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=UTF-8");

		String username = request.getParameter("Username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String password3 = request.getParameter("password3");

		// 取得現在時間
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String updateDate = sdFormat.format(date);

		// 3. 檢查使用者輸入資料

		MemberBeanString errorMember = new MemberBeanString();

		if (password1 == null || password1.trim().length() == 0) {
			return;
		}

		if (password2 == null || password2.trim().length() == 0) {
			return;
		}
		if (password3 == null || password3.trim().length() == 0) {
			return;
		}
		
		MemberService ls = new MemberService();
		MemberBean mb = null;
		try {
			mb = ls.checkIDPassword(username, password1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(mb == null){
			return;
		}else {
			if(!password2.equals(password3)){
				return;
			}
		}


		try (PrintWriter out = response.getWriter();) {

			try {
				password2 = AES.encrypt(password2);
				//密碼加密	
				
				MemberBean mem = new MemberBean(username, password2 ,updateDate);
				MemberDAO mDAO = new MemberDAO();
				errorMember.setDML_Result(mDAO.updatePassword(mem));

				String toJson = null;
				if (errorMember.getDML_Result() == null) {
					// 新增成功

					String stringResult = "Success";
					toJson = new Gson().toJson(stringResult);
					MemberBean new_mem = mDAO.select(mem.getM_Username()).iterator().next(); 
					HttpSession session = request.getSession();
//	
					session.setAttribute("MemberLoginOK", new_mem);

				}

				System.out.println(toJson);
				out.println(toJson);

			} catch (Exception e) {
				// errorMsg.put("exception","資料庫存取錯誤");
				System.out.println("資料庫存取錯誤");
				e.printStackTrace();
			}

			
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		doPost(request, response);
	}

}