package _21_ShoppingOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import _14_Member.MemberBean;


public class OrderBeanDAO {
	
	Context ctx;
	DataSource ds;
	
	public OrderBeanDAO(){
	
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


	synchronized public String insert(OrderBean ord){
	
		String sql = "INSERT INTO `Order` VALUES(? ,?, ?, ?, ?)";
		
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setString(1, ord.getOrderId());
			pstmt.setString(2, ord.getOrderDate());
			pstmt.setString(3, ord.getShippedDate());	
			pstmt.setString(4, ord.getM_Username());
			pstmt.setInt(5, ord.getOrderTotal());
			
									
			pstmt.executeUpdate();
			
			System.out.println("新增" + ord.getOrderId()+"成功 ");
			
			return null;
		}catch (Exception e){
			
			e.printStackTrace();
			return "新增" + ord.getOrderId()+"失敗";
		}
		
	}
	public int delete(String orderId){
	
		String sql = "DELETE FROM Order WHERE OrderId =? ;";
		try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
		){
			pstmt.setString(1, orderId);
			pstmt.executeUpdate();
			System.out.println("成功 刪除 "+ orderId);
			
			return 1;
		}catch (SQLException e){
			System.out.println("失敗 刪除 "+ orderId);
			e.printStackTrace();
			return 0;
		}
	}
	
	synchronized public int updateOrderTotal(String orderId, Integer orderTotal){
		
		String sql = "UPDATE `Order` SET `OrderTotal` = ? WHERE `OrderId` = ?;";
		try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
		){
			pstmt.setInt(1, orderTotal);
			pstmt.setString(2, orderId);
			pstmt.executeUpdate();
			System.out.println("成功 更新 "+ orderId+"的 orderTotal");
			
			return 1;
		}catch (SQLException e){
			System.out.println("失敗 更新 "+ orderId+"的 orderTotal");
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
	public Collection<OrderBean> getMemberOrder(String Username){
		
		String sql = "select * from Order where M_Username =?"					
					+ ";";
						
		Collection<OrderBean> coll = new ArrayList<>();
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setString(1, Username);
			try(
				ResultSet rs = pstmt.executeQuery();
			){
				if (rs.next()){					
					OrderBean pb = new OrderBean();
								
					pb.setOrderId(rs.getString(1));
					pb.setOrderDate(rs.getString(2));			
					pb.setShippedDate(rs.getString(3));	
					pb.setM_Username(rs.getString(4));
					pb.setOrderTotal(rs.getInt(5));
					
					
					coll.add(pb);					
				}
				
				System.out.println("記錄 查詢會員"+Username+"的訂單");
			}
			return coll;
		}catch (Exception e){
			
			e.printStackTrace();
		}
		return null;
	}
	

}
	
	
	

