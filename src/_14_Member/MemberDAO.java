﻿package _14_Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import _00_Util.SystemConstant;





public class MemberDAO {
	
	Context ctx;
	DataSource ds;
	private int recordsPerPage = SystemConstant.RECORDS_PER_PAGE; // 每頁?筆
	private int pageNo = 1;
	private int totalPages = -1;

	public MemberDAO(){
	
		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		try {
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Java004NO1");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}
	
//-------------------頁數區塊     begin------------------------------------------------------
	
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}
	
	public int getRecordCounts() throws SQLException {
		String sql = "SELECT count(*) FROM Member";
		int result = 0;
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			try (ResultSet rs = pstmt.executeQuery();) {

				if (rs.next()) {
					result = rs.getInt(1);
				}
			}
		}
		return result;
	}
	
	public int getTotalPages() throws SQLException {
		// 計算總共有幾頁
		if (totalPages == -1) {
			// 注意下一列的double型態轉換
			totalPages = (int) (Math.ceil(getRecordCounts()
					/ (double) recordsPerPage));
		}
		return totalPages;
	}
	
	//-------------------頁數區塊     end------------------------------------------------------
	
	
	
	
	synchronized public String insert(MemberBean mem){
	
		String sql = "INSERT INTO Member "
				+ " VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
			int i=0;
			pstmt.setString(++i, mem.getM_Username());
			pstmt.setString(++i, mem.getM_Password());
			pstmt.setString(++i, mem.getM_Name());
			pstmt.setString(++i, mem.getM_Address());
			pstmt.setString(++i, mem.getM_Cellphone());
			pstmt.setString(++i, mem.getM_Birthday());
			pstmt.setString(++i, mem.getM_Insertdate());
			pstmt.setString(++i, mem.getM_Updatedate());
			pstmt.setInt(++i, mem.getM_Level());
			pstmt.setInt(++i, mem.getM_BonusPoints());
			pstmt.setInt(++i, mem.getM_Total());
			pstmt.setBoolean(++i, mem.isM_Certification());
									
			pstmt.executeUpdate();
			
			System.out.println("新增" + mem.getM_Username()+"成功 ");
			
			return null;
		}catch (Exception e){
			
			if(ifExist(mem.getM_Username())){
				System.out.println(mem.getM_Username()+"已經存在");
				return mem.getM_Username()+"已經存在";
			}
			System.out.println("新增" + mem.getM_Username()+"失敗");
			e.printStackTrace();
			return "新增" + mem.getM_Username()+"失敗";
		}
		
	}
	public int delete(String username){
	
		String sql = "DELETE FROM Member WHERE M_Username =? ;";
		try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
		){
			pstmt.setString(1, username);
			pstmt.executeUpdate();
			System.out.println("成功 刪除 "+ username);
			
			return 1;
		}catch (SQLException e){
			System.out.println("失敗 刪除 "+ username);
			e.printStackTrace();
			return 0;
		}
	}
	
	synchronized public String update(MemberBean mem){
		
		String sql = "UPDATE `Member` SET "
				+ "`M_Name`=?, `M_Address`=?, `M_Cellphone`=?, `M_Birthday`=?, `M_UpdateDate`=?" 
				+ "WHERE `M_Username`=?;";
		
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
			int i=0;
			pstmt.setString(++i, mem.getM_Name());
			pstmt.setString(++i, mem.getM_Address());
			pstmt.setString(++i, mem.getM_Cellphone());
			pstmt.setString(++i, mem.getM_Birthday());
			pstmt.setString(++i, mem.getM_Updatedate());
			pstmt.setString(++i, mem.getM_Username());
					
			pstmt.executeUpdate();
			
			System.out.println("成功 修改" + mem.getM_Username());
			
			return null;
		}catch (Exception e){		
			System.out.println("失敗 修改" + mem.getM_Username());
			e.printStackTrace();
			return "失敗 修改" + mem.getM_Username();
		}
		
	}
	
synchronized public String updatePassword(MemberBean mem){
		
		String sql = "UPDATE `Member` SET "
				+ "`M_Password`=?" 
				+ "WHERE `M_Username`=?;";
		
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
			int i=0;
			pstmt.setString(++i, mem.getM_Password());
			pstmt.setString(++i, mem.getM_Username());
					
			pstmt.executeUpdate();
			
			System.out.println("成功 修改密碼" + mem.getM_Username());
			
			return null;
		}catch (Exception e){		
			System.out.println("失敗 修改密碼" + mem.getM_Username());
			e.printStackTrace();
			return "失敗 修改密碼" + mem.getM_Username();
		}
		
	}
	public boolean checkCertification(String Username){
		
		String sql = "select M_Certification from Member where M_Username =?"					
					+ ";";
		MemberBean pb = new MemberBean();				
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setString(1, Username);
			try(
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()){					
					
					
					pb.setM_Certification(rs.getBoolean(1));
												
				}
				
				System.out.println("記錄 查詢"+Username+"的認證");
			}
			return pb.isM_Certification();
		}catch (Exception e){
			
			e.printStackTrace();
		}
		return false;
	}
	synchronized public String Certification(String username){
		
		String sql = "UPDATE `Member` SET `M_Certification`=? WHERE `M_Username`=?;";
		
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setBoolean(1, true);
			pstmt.setString(2, username);
					
			pstmt.executeUpdate();
			
			System.out.println("成功 認證" + username);
			
			return null;
		}catch (Exception e){		
			System.out.println("失敗 認證" + username);
			e.printStackTrace();
			return "失敗 認證" + username;
		}
		
	}
	
	
	
	public Collection<MemberBean> select(String Username){
	
		String sql = "select * from Member where M_Username =?"					
					+ ";";
						
		Collection<MemberBean> coll = new ArrayList<>();
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setString(1, Username);
			try(
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()){					
					MemberBean pb = new MemberBean();
					
					int i=0;
					
					pb.setM_Username(rs.getString(++i));
					pb.setM_Password(rs.getString(++i));			
					pb.setM_Name(rs.getString(++i));
					pb.setM_Address(rs.getString(++i));
					pb.setM_Cellphone(rs.getString(++i));
					pb.setM_Birthday(rs.getString(++i));
					pb.setM_Insertdate(rs.getString(++i));
					pb.setM_Updatedate(rs.getString(++i));
					pb.setM_Level(rs.getInt(++i));
					pb.setM_BonusPoints(rs.getInt(++i));
					pb.setM_Total(rs.getInt(++i));
					pb.setM_Certification(rs.getBoolean(++i));
					
					coll.add(pb);					
				}
				
				System.out.println("記錄 查詢單筆");
			}
			return coll;
		}catch (Exception e){
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Collection<MemberBean> select() {

		String sql = "select * from Member"+";";

		Collection<MemberBean> coll = new ArrayList<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					MemberBean pb = new MemberBean();
					
					int i=0;
					
					pb.setM_Username(rs.getString(++i));
					pb.setM_Password(rs.getString(++i));			
					pb.setM_Name(rs.getString(++i));
					pb.setM_Address(rs.getString(++i));
					pb.setM_Cellphone(rs.getString(++i));
					pb.setM_Birthday(rs.getString(++i));
					pb.setM_Insertdate(rs.getString(++i));
					pb.setM_Updatedate(rs.getString(++i));
					pb.setM_Level(rs.getInt(++i));
					pb.setM_BonusPoints(rs.getInt(++i));
					pb.setM_Total(rs.getInt(++i));
					pb.setM_Certification(rs.getBoolean(++i));
					
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
	
	
	public Collection<MemberBean> selectToUpdate(String Username){
		
		String sql = "select * from Member where M_Username =?"					
					+ ";";
						
		Collection<MemberBean> coll = new ArrayList<>();
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setString(1, Username);
			try(
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()){					
					MemberBean pb = new MemberBean();
					
					pb.setM_Username(rs.getString(1));
					pb.setM_Password(rs.getString(2));			
					pb.setM_Name(rs.getString(3));	
					pb.setM_Cellphone(rs.getString(4));
					pb.setM_Birthday(rs.getString(5));
					pb.setM_Insertdate(rs.getString(6));
					pb.setM_Updatedate(rs.getString(7));
					pb.setM_Level(rs.getInt(8));
					pb.setM_BonusPoints(rs.getInt(9));
					pb.setM_Total(rs.getInt(10));

					coll.add(pb);					
				}
				
				System.out.println("記錄 查詢單筆");
			}
			return coll;
		}catch (Exception e){
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
public Boolean ifExist(String Username){
		
		String sql = "select * from Member where M_Username =?"					
					+ ";";
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setString(1, Username);
			try(
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()){					
					return true;					
				}else{
					return false;
				}
				
			}
		}catch (Exception e){
			
			e.printStackTrace();
		}
		return null;
	}
	
	public Collection<MemberBean> getPageMembers() {

		String sql = "select * from Member limit ?,?;";

		Collection<MemberBean> coll = new ArrayList<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			
			
			int startRecordNo = (pageNo - 1) * recordsPerPage ;
			//第一頁:0~9   共10筆
		
			pstmt.setInt(1, startRecordNo);
			pstmt.setInt(2, recordsPerPage);
			
			
			try (ResultSet rs = pstmt.executeQuery();) {
				
				
				
				while (rs.next()) {
					MemberBean pb = new MemberBean();
					
					int i=0;
					
					pb.setM_Username(rs.getString(++i));
					pb.setM_Password(rs.getString(++i));			
					pb.setM_Name(rs.getString(++i));
					pb.setM_Address(rs.getString(++i));
					pb.setM_Cellphone(rs.getString(++i));
					pb.setM_Birthday(rs.getString(++i));
					pb.setM_Insertdate(rs.getString(++i));
					pb.setM_Updatedate(rs.getString(++i));
					pb.setM_Level(rs.getInt(++i));
					pb.setM_BonusPoints(rs.getInt(++i));
					pb.setM_Total(rs.getInt(++i));
					pb.setM_Certification(rs.getBoolean(++i));
					
					coll.add(pb);
				}

				System.out.println("記錄 查詢orderBy Limit");
			}
			return coll;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}
	
public MemberBean findMemberByUBC(String Username , String Birthday , String Cellphone){
		
		String sql = "select * from Member where M_Username =? "
				+ "and M_Birthday =? and M_Cellphone = ?;";
		
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
			MemberBean pb = new MemberBean();
			
			pstmt.setString(1,Username);
			pstmt.setString(2,Birthday);
			pstmt.setString(3,Cellphone);
			try(
				ResultSet rs = pstmt.executeQuery();					
			){	
				if (rs.next()){					
			
					
					pb.setM_Username(rs.getString(1));
					pb.setM_Password(rs.getString(2));			
					pb.setM_Name(rs.getString(3));	
					pb.setM_Cellphone(rs.getString(4));
					pb.setM_Birthday(rs.getString(5));
					pb.setM_Insertdate(rs.getString(6));
					pb.setM_Updatedate(rs.getString(7));
					pb.setM_Level(rs.getInt(8));
					pb.setM_BonusPoints(rs.getInt(9));
					pb.setM_Total(rs.getInt(10));				
				}
				return pb;
			}
			
		}catch (Exception e){			
			e.printStackTrace();
		}
		return null;
	}
	
	
}
