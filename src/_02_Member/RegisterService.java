package _02_Member;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _00_Util.SystemConstant;

public class RegisterService {
	static private List<String> memberIDList = new ArrayList<String>();
	Context ctx;
	
	synchronized public int insert(Member mem){
	
		int n =0;
		String sql = "INSERT INTO Member "
				+ " VALUES(? ,?, ?, ?, ?, ?)"; 
		try{
			
			Context ctx	= new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/java004");
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);				
		
			pstmt.setString(1, mem.getM_ID());
			pstmt.setString(2, mem.getM_Username());
			pstmt.setString(3, mem.getM_Password());
			pstmt.setString(4, mem.getM_Name());
			pstmt.setString(5, mem.getM_EMail());
			pstmt.setString(6, mem.getM_Phone());
			
			n = pstmt.executeUpdate();
			memberIDList.add(mem.getM_ID());
			System.out.println("記錄 新增id = " + mem.getM_ID());			
		}catch (Exception e){
			System.out.println("記錄 新增失敗id = " + mem.getM_ID());
			e.printStackTrace();
		}
		return n;
	}

	public boolean idExists(String id) throws IOException {
		boolean exist = false;
		for (String s : memberIDList) {
			if (s.equals(id.trim())) {
				exist = true;
				break;
			}
		}
		return exist;
	}

}
