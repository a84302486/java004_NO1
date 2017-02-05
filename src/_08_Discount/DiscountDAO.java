package _08_Discount;

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

public class DiscountDAO {
	
	Context ctx;
	DataSource ds;

	public DiscountDAO(){

		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			e1.printStackTrace();
		}	
		try {
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/java004");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}
	
		synchronized public String insert(DiscountBean db){
			
			String sql = "INSERT INTO discount "
					+ " VALUES(?, ?)";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
				){				
			
				pstmt.setString(1, db.getDiscountId());
				pstmt.setDouble(2, db.getDescription());
				pstmt.executeUpdate();
				
				System.out.println("成功 新增" + db.getDiscountId());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 新增" + db.getDiscountId());
				e.printStackTrace();
				return "失敗 新增" + db.getDiscountId();
			}	
		}
		
		public boolean delete(String discountId){
		
			String sql = "DELETE FROM discount WHERE discount_id =? ;";
			try(
					Connection con = ds.getConnection();
					PreparedStatement pstmt	= con.prepareStatement(sql);
				){
				
				pstmt.setString(1, discountId);
				pstmt.executeUpdate();
				System.out.println("成功 刪除 "+ discountId);
				return true;
				
			}catch (SQLException e){
				System.out.println("失敗 刪除 "+ discountId);
				e.printStackTrace();
				return false;
			}
			
		}
		
		synchronized public String update(DiscountBean db){
			
			String sql = "UPDATE discount SET "
					+ "discount_id = ?, description = ? WHERE discount_id = ?;";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
				pstmt.setString(1, db.getDiscountId());
				pstmt.setDouble(2, db.getDescription());
				pstmt.executeUpdate();
				
				System.out.println("成功 修改" + db.getDiscountId());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 修改" + db.getDiscountId());
				e.printStackTrace();
				return "失敗 修改" + db.getDiscountId();
			}
		}
		
		public Collection<DiscountBean> findByPrimaryKey(String discountId) {

			String sql = "select * from discount where discount_id = ?;";

			Collection<DiscountBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				
				pstmt.setString(1, discountId);
				
				try (ResultSet rs = pstmt.executeQuery();) {
					
					while (rs.next()) {
						DiscountBean db = new DiscountBean();
						db.setDiscountId(rs.getString(1));
						db.setDescription(rs.getDouble(2));
						coll.add(db);
					}
					System.out.println("序號查詢資料");
				}
				return coll;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Collection<DiscountBean> findAll() {

			String sql = "select * from discount;";

			Collection<DiscountBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

				try (ResultSet rs = pstmt.executeQuery();) {

					while (rs.next()) {
						DiscountBean db = new DiscountBean();
						db.setDiscountId(rs.getString(1));
						db.setDescription(rs.getDouble(2));
						coll.add(db);
						coll.add(db);
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

