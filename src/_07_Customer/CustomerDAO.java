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
	
	synchronized public String insert(CustomerBean mem){
	
		int n =0;
		String sql = "INSERT INTO Customer "
				+ " VALUES(? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";
		
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setString(1, mem.getCustomer_id());
			pstmt.setString(2, mem.getSimple_Name());
			pstmt.setString(3, mem.getName());
			pstmt.setString(4, mem.getSale_Path());
			pstmt.setString(5, mem.getTelephone());
			pstmt.setString(6, mem.getFax());
			pstmt.setString(7, mem.getContacter());		
			pstmt.setString(8, mem.getAddress());
			pstmt.setString(9, mem.getUniform_NO());
			pstmt.setString(10, mem.getThis_Invertory_Date());
			pstmt.setString(11, mem.getLast_Invertory_Date());
			pstmt.setString(12, mem.getPR_Status());
			pstmt.setString(13, mem.getCurrent_Discount_id());
			pstmt.setString(14, mem.getNext_Discount_id());
			pstmt.setString(15, mem.getTax_Type());
			pstmt.setString(16, mem.getURL());
			pstmt.setString(17, mem.getPrincipal_Name());
			pstmt.setString(18, mem.getContact_Name());
			pstmt.setString(19, mem.getEmail());
			pstmt.setString(20, mem.getLine());
			pstmt.setString(21, mem.getSkype());
						
			n = pstmt.executeUpdate();
			
			System.out.println("成功 新增" + mem.getCustomer_id());
			
			return null;
		}catch (Exception e){		
			System.out.println("失敗 新增" + mem.getCustomer_id());
			e.printStackTrace();
			return "失敗 新增" + mem.getCustomer_id();
		}
		
	}
	public int delete(String Customer_id){
		int n =0;
		String sql = "DELETE FROM Customer WHERE Customer_id =? ;";
		try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
		){
			pstmt.setString(1, Customer_id);
			n = pstmt.executeUpdate();
			System.out.println("成功 刪除 "+ Customer_id);
			
			return n;
		}catch (SQLException e){
			System.out.println("失敗 刪除 "+ Customer_id);
			e.printStackTrace();
			return n;
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
					pb.setCustomer_id(rs.getString(1));
					pb.setSimple_Name(rs.getString(2));
					pb.setName(rs.getString(3));
					pb.setSale_Path(rs.getString(4));
					pb.setTelephone(rs.getString(5));
					pb.setFax(rs.getString(6));
					pb.setContacter(rs.getString(7));
					pb.setAddress(rs.getString(8));
					pb.setUniform_NO(rs.getString(9));
					pb.setThis_Invertory_Date(rs.getString(10));
					pb.setLast_Invertory_Date(rs.getString(11));
					pb.setPR_Status(rs.getString(12));
					pb.setCurrent_Discount_id(rs.getString(13));
					pb.setNext_Discount_id(rs.getString(14));
					pb.setTax_Type(rs.getString(15));
					pb.setURL(rs.getString(16));
					pb.setPrincipal_Name(rs.getString(17));
					pb.setContact_Name(rs.getString(18));
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
