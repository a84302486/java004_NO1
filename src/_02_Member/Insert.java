package _02_Member;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/_02_Member/insert.do")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {
    	request.setCharacterEncoding("UTF-8");
		// 準備存放錯誤訊息的 List 物件
		List<String> errorMsg = new ArrayList<String>();
		
        request.setAttribute("ErrorMsgKey", errorMsg); 
		
        // 1. 讀取使用者輸入資料
        
        String ID = request.getParameter("ID");
        
		String Username = request.getParameter("Username");
		String Password = request.getParameter("Password");
		String Name = request.getParameter("Name");
		String Nick = request.getParameter("Nick");
		String Sex = request.getParameter("Sex");
		String Birthday = request.getParameter("Birthday");
		String EMail = request.getParameter("EMail");
		String Phone = request.getParameter("Phone");
		String Cellphone = request.getParameter("Cellphone");
		String Address = request.getParameter("Address");		
		String Line = request.getParameter("Line");
		String FaceBook = request.getParameter("FaceBook");
		String IdentityCard = request.getParameter("IdentityCard");
		String Invoice = request.getParameter("Invoice");
		String UniformNumber = request.getParameter("UniformNumber");
				
		//取得現在時間
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		Date date = new Date();
		String Joindate = sdFormat.format(date); 
			
		
		// 2. 進行必要的資料轉換
		
		
		// 3. 檢查使用者輸入資料
		if (ID == null || ID.trim().length() == 0) {
			errorMsg.add("會員卡號必須輸入");
		}
		if (Username == null || Username.trim().length() == 0) {
			errorMsg.add("帳號欄必須輸入");
		}
		if (Password == null || Password.trim().length() == 0) {
			errorMsg.add("密碼欄必須輸入");
		}
		if (Name == null || Name.trim().length() == 0) {
			errorMsg.add("姓名欄必須輸入");
		}
		if (EMail == null || EMail.trim().length() == 0) {
			errorMsg.add("EMail欄必須輸入");
		}
		if (Phone == null || Phone.trim().length() == 0) {
			errorMsg.add("電話號碼欄必須輸入");
		}
		
		
		if (!errorMsg.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			return;
		}
	
		RegisterService rs = new RegisterService();
		String insertError = null;
			
		
			try {
				Member mem = new Member(ID,Username,Password,Name,Nick,Sex,
						Birthday,EMail,Phone,Cellphone,Address,Line,
						FaceBook,IdentityCard,Invoice,UniformNumber,Joindate
						);
				insertError = rs.insert(mem);
			} catch (Exception e) {
				errorMsg.add("儲存資料時發生錯誤，請檢查，例外=" + e.getMessage());
				e.printStackTrace();
			}
		if(insertError!=null){
			errorMsg.add(insertError);
		}
			
		
		// 5.依照 Business Logic 運算結果來挑選適當的畫面
		request.setAttribute("M_Username", Username);
		if (errorMsg.isEmpty())	{			
			RequestDispatcher rd = request.getRequestDispatcher("insert_success.jsp");
			rd.forward(request, response);
			return ; 
		}  else {
			RequestDispatcher rd = request.getRequestDispatcher("insert_error.jsp");
			rd.forward(request, response);
			return;
		}
     }
}   