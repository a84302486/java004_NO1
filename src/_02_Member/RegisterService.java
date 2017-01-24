package _02_Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RegisterService {
	
	Context ctx;
	
	synchronized public int insert(Member mem){
	
		int n =0;
		String sql = "INSERT INTO Member "
				+ " VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,null,null,null)";
		
		Context ctx = null;
		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DataSource ds = null;
		try {
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/java004");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setString(1, mem.getM_ID());
			pstmt.setString(2, mem.getM_Username());
			pstmt.setString(3, mem.getM_Password());
			pstmt.setString(4, mem.getM_Name());
			pstmt.setString(5, mem.getM_Nick());
			pstmt.setString(6, mem.getM_Sex());
			pstmt.setString(7, mem.getM_Birthday());		
			pstmt.setString(8, mem.getM_EMail());
			pstmt.setString(9, mem.getM_Phone());
			pstmt.setString(10, mem.getM_Cellphone());
			pstmt.setString(11, mem.getM_Address());
			pstmt.setString(12, mem.getM_Line());
			pstmt.setString(13, mem.getM_FaceBook());
			pstmt.setString(14, mem.getM_IdentityCard());
			pstmt.setString(15, mem.getM_Invoice());
			pstmt.setString(16, mem.getM_UniformNumber());
			pstmt.setString(17, mem.getM_Joindate());
			
			n = pstmt.executeUpdate();
		
			System.out.println("成功 新增" + mem.getM_Username());			
		}catch (Exception e){
			System.out.println("失敗 新增" + mem.getM_Username());
			e.printStackTrace();
		}
		return n;
	}
	
	public String findByPrimaryKey(String Username){
		
		int n =0;
		String sql = "select Name from Member where Username =?;";
				 
		Context ctx = null;
		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DataSource ds = null;
		try {
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/java004");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setString(1, Username);
			try(
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()){					
					String Name = rs.getString(1);					
				}
			}			
		}catch (Exception e){
			
			e.printStackTrace();
		}
		return null;
	}
	
}
