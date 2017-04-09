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
import javax.sql.DataSource;

import _01_Product.ProductBean;
import _01_Product.ProductDAO;
import _14_Member.MemberBean;


public class OrderDetailBeanDAO {
	
	Context ctx;
	DataSource ds;
	
	public OrderDetailBeanDAO(){
	
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


	synchronized public String insert(OrderDetailBean ordDetail){
	
		String sql = "INSERT INTO OrderDetail VALUES(? ,?, ?, ?, ?, ?, ?)";
		
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
			ProductBean temp = ordDetail.getProductBean();
			
			pstmt.setString(1, ordDetail.getOrderId());
			pstmt.setString(2, temp.getProductId());
			pstmt.setString(3, temp.getName());	
			pstmt.setInt(4, temp.getPgPrice());
			pstmt.setInt(5, ordDetail.getQuantity());
			pstmt.setInt(6, ordDetail.getSubTotal());
			pstmt.setInt(7, -1);
			
									
			pstmt.executeUpdate();
			
			System.out.println("新增" + temp.getProductId()+"的OrderDetail 成功 ");
			
			return null;
		}catch (Exception e){
			
			e.printStackTrace();
			return "新增OrderDetail 失敗";
		}
		
	}
	public int delete(String orderId){
	
		String sql = "DELETE FROM OrderDetail WHERE OrderId =? ;";
		try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
		){
			pstmt.setString(1, orderId);
			int i = pstmt.executeUpdate();
			System.out.println("成功 刪除 "+ orderId+"的OrderDetail");
			
			return i;
		}catch (SQLException e){
			System.out.println("失敗 刪除 "+ orderId+"的OrderDetail");
			e.printStackTrace();
			return 0;
		}
	}
	
	public Collection<OrderDetailBean> select(String OrderId){
	
		String sql = "select * from `OrderDetail` where `OrderId`=?;";				
								
		Collection<OrderDetailBean> coll = new ArrayList<>();
		try(
			Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);){				
		
			pstmt.setString(1, OrderId);
			try(
				ResultSet rs = pstmt.executeQuery();
			){
				while(rs.next()){					
					OrderDetailBean pb = new OrderDetailBean();
					
					pb.setOrderId(rs.getString(1));//OrderId
					ProductBean pBean = new ProductDAO().findByPrimaryKey(rs.getString(2)).iterator().next();
					pb.setProductBean(pBean);
					rs.getString(3);
					rs.getInt(4);
					pb.setQuantity(rs.getInt(5));
					pb.setSubTotal(rs.getInt(6));
					pb.setScore(rs.getDouble(7));
					coll.add(pb);	
					
				}
				
				System.out.println("記錄 查詢"+OrderId+"的OrderDetail");
			}
			return coll;
		}catch (Exception e){
			
			e.printStackTrace();
		}
		return null;
	}
		
	public void setScore(double score ,String orderId, String productId){
		
	
		String sql = "UPDATE OrderDetail SET score = ? where (OrderId=? and Product_Id = ?);";
		
		try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
		){
			pstmt.setDouble(1, score);
			pstmt.setString(2, orderId);
			pstmt.setString(3, productId);
			pstmt.executeUpdate();
			System.out.println("成功評價 "+orderId+"的"+productId+"得分="+score);
			
		}catch (SQLException e){
			System.out.println("失敗評價 "+orderId+"的"+productId);
			e.printStackTrace();

		}	
	} 

	public void setScoreToProduct(double score , String productId){
		
		String sql = "UPDATE Product SET score = ? where Product_Id = ?;";
		
		try(Connection con = ds.getConnection();
			PreparedStatement pstmt	= con.prepareStatement(sql);
			){
			pstmt.setDouble(1, score);
			pstmt.setString(2, productId);
			pstmt.executeUpdate();
			
		}catch (SQLException e){
			e.printStackTrace();
		}	
	}
	 
	public double getScoreAvg(String productId) {

		String sql = "select round(avg(score),1) from OrderDetail where Product_Id = ? and score > 0;";

		try (Connection con = ds.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, productId);

			double score = 0;
			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					score = rs.getDouble(1);
				}
				System.out.println("查詢" + productId + "評價=" + score + "星");
			}
		
			return score;
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return 0;

	}
}
	
	
	

