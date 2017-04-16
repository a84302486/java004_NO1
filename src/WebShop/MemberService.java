package WebShop;

import java.util.Collection;

import _00_Util.AES;
import _14_Member.MemberBean;
import _14_Member.MemberDAO;

public class MemberService {
	public MemberBean checkIDPassword(String Username, String Password) throws Exception {
		// 將 MemberDAO new為物件，放入變數dao內
		MemberDAO dao = new MemberDAO();
		// 透過變數dao，呼叫它的select()方法，要傳入參數 id。將傳回值放入變數
        // MemberBean mb 內。
		MemberBean mb = null;
		Collection<MemberBean> coll = dao.select(Username);
		if(coll.iterator().hasNext()){
			 mb = coll.iterator().next();
		}else{
			return null;
		}
        // 如果mb不等於 null 而且參數 password等於mb內的password) {
        if ( mb != null ) {
//        	String passwordDecrypt = AES.decrypt(mb.getM_Password());
        	
//        	System.out.println("mb的密碼 "+passwordDecrypt);
//        	System.out.println("輸入的密碼 "+Password);
        	if(Password.equals(mb.getM_Password())) {
        		
        		System.out.println("登入 輸入密碼正確");
        		// 傳回 mb物件，同時結束本方法       	 
        		return mb;
        	} 
        }
        // 傳回null物件
		return null;
	}
}
