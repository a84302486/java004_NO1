package _07_Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;




public class CustomerDAO {
	
	Context ctx;
	DataSource ds;
	

	
	public CustomerDAO(){

		
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
	
	synchronized public String insert(CustomerBean cb){
	
		int n =0;
		String sql = "INSERT INTO Customer "
				+ " VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
		
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setString(1, cb.getCustomerId());
			pstmt.setString(2, cb.getSimpleName());
			pstmt.setString(3, cb.getName());
			pstmt.setString(4, cb.getSalePath());
			pstmt.setString(5, cb.getTelephone());
			pstmt.setString(6, cb.getFax());
			pstmt.setString(7, cb.getContacter());		
			pstmt.setString(8, cb.getAddress());
			pstmt.setString(9, cb.getUniformNO());
			pstmt.setString(10, cb.getThisInvertoryDate());
			pstmt.setString(11, cb.getLastInvertoryDate());
			pstmt.setString(12, cb.getPrStatus());
			pstmt.setString(13, cb.getCurrentDiscountId());
			pstmt.setString(14, cb.getNextDiscountId());
			pstmt.setString(15, cb.getTaxType());
			pstmt.setString(16, cb.getUrl());
			pstmt.setString(17, cb.getPrincipalName());
			pstmt.setString(18, cb.getContactName());
			pstmt.setString(19, cb.getEmail());
			pstmt.setString(20, cb.getLine());
			pstmt.setString(21, cb.getSkype());
			n = pstmt.executeUpdate();
			
			System.out.println("成功 新增" + cb.getCustomerId());
			
			return null;
		}catch (Exception e){		
			System.out.println("失敗 新增" + cb.getCustomerId());
			e.printStackTrace();
			return "失敗 新增" + cb.getCustomerId();
		}
		
	}
	public boolean delete(String CustomerId){

		String sql = "DELETE FROM Customer WHERE Customer_id =? ;";
		try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
		){
			pstmt.setString(1, CustomerId);
			pstmt.executeUpdate();
			System.out.println("成功 刪除 "+ CustomerId);
			
			return true;
		}catch (SQLException e){
			System.out.println("失敗 刪除 "+ CustomerId);
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	public String findByPrimaryKey(String Customer_id){
		
		int n =0;
		String sql = "select Name from Customer where Customer_id =?;";
				 		
		String Name = null;	
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setString(1, Customer_id);
			try(
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()){					
					Name = rs.getString(1);					
				}
			}
			return Name;
		}catch (Exception e){
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Collection<CustomerBean> findAll() {

		int n = 0;
		String sql = "select * from Customer;";

		Collection<CustomerBean> coll = new ArrayList<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					CustomerBean pb = new CustomerBean();
					pb.setCustomerId(rs.getString(1));
					pb.setSimpleName(rs.getString(2));
					pb.setName(rs.getString(3));
					pb.setSalePath(rs.getString(4));
					pb.setTelephone(rs.getString(5));
					pb.setFax(rs.getString(6));
					pb.setContacter(rs.getString(7));
					pb.setAddress(rs.getString(8));
					pb.setUniformNO(rs.getString(9));
					pb.setThisInvertoryDate(rs.getString(10));
					pb.setLastInvertoryDate(rs.getString(11));
					pb.setPrStatus(rs.getString(12));
					pb.setCurrentDiscountId(rs.getString(13));
					pb.setNextDiscountId(rs.getString(14));
					pb.setTaxType(rs.getString(15));
					pb.setUrl(rs.getString(16));
					pb.setPrincipalName(rs.getString(17));
					pb.setContactName(rs.getString(18));
					pb.setEmail(rs.getString(19));
					pb.setLine(rs.getString(20));
					pb.setSkype(rs.getString(21));

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
