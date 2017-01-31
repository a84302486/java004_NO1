package _14_Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




public class RegisterService {
	
	Context ctx;
	DataSource ds;
	
<<<<<<< HEAD
	synchronized public String insert(MemberBean mem){
		
		int n =0;
		String sql = "INSERT INTO Member "
				+ " VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,null,null,null)";
=======
	public RegisterService(){
>>>>>>> d48c8907b47ff2afb7865ac2ada9c76f62789c18
		
		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		try {
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/java004");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}
	
	synchronized public String insert(Member mem){
	
		int n =0;
		String sql = "INSERT INTO Member "
				+ " VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,null,null,null)";
		
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
			
			return null;
		}catch (Exception e){		
			System.out.println("失敗 新增" + mem.getM_Username());
			e.printStackTrace();
			return "失敗 新增" + mem.getM_Username();
		}
		
	}
	
	public String findByPrimaryKey(String Username){
		
		int n =0;
		String sql = "select M_Name from Member where M_Username =?;";
				 		
		String M_Name = null;	
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setString(1, Username);
			try(
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()){					
					M_Name = rs.getString(1);					
				}
			}
			return M_Name;
		}catch (Exception e){
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Collection<Member> findAll() {

		int n = 0;
		String sql = "select * from Member;";

		Collection<Member> coll = new ArrayList<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					Member pb = new Member();
					pb.setM_ID(rs.getString(1));
					pb.setM_Username(rs.getString(2));
					pb.setM_Password(rs.getString(3));
					pb.setM_Name(rs.getString(4));
					pb.setM_Nick(rs.getString(5));
					pb.setM_Sex(rs.getString(6));
					pb.setM_Birthday(rs.getString(7));
					pb.setM_EMail(rs.getString(8));
					pb.setM_Phone(rs.getString(9));
					pb.setM_Cellphone(rs.getString(10));
					pb.setM_Address(rs.getString(11));
					pb.setM_Line(rs.getString(12));
					pb.setM_FaceBook(rs.getString(13));
					pb.setM_IdentityCard(rs.getString(14));
					pb.setM_Invoice(rs.getString(15));
					pb.setM_UniformNumber(rs.getString(16));
					pb.setM_Joindate(rs.getString(17));

					coll.add(pb);
				}

				System.out.println("記錄 查詢all");
			}
			return coll;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}
}
