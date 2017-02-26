package _02_Taste;

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

public class TasteDAO {
	
	Context ctx;
	DataSource ds;

	public TasteDAO(){

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
	
		synchronized public String insert(TasteBean tb){
			
			String sql = "INSERT INTO Taste "
					+ " VALUES(? , ?)";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
				){				
			
				pstmt.setString(1, tb.getTasteId());
				pstmt.setString(2, tb.getTasteName());
				pstmt.executeUpdate();
				
				System.out.println("成功 新增" + tb.getTasteId());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 新增" + tb.getTasteId());
				e.printStackTrace();
				return "失敗 新增" + tb.getTasteId();
			}	
		}
		
		public boolean delete(String tasteId){
		
			String sql = "DELETE FROM Taste WHERE Taste_id =? ;";
			try(
					Connection con = ds.getConnection();
					PreparedStatement pstmt	= con.prepareStatement(sql);
				){
				
				pstmt.setString(1, tasteId);
				pstmt.executeUpdate();
				System.out.println("成功 刪除 "+ tasteId);
				return true;
				
			}catch (SQLException e){
				System.out.println("失敗 刪除 "+ tasteId);
				e.printStackTrace();
				return false;
			}
		}
		
		synchronized public String update(TasteBean tb){
			
			String sql = "UPDATE Taste SET "
					+ "taste_id = ?, taste_name = ? WHERE taste_id = ?;";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
				pstmt.setString(1, tb.getTasteId());
				pstmt.setString(2, tb.getTasteName());	
				pstmt.executeUpdate();
				
				System.out.println("成功 修改" + tb.getTasteId());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 修改" + tb.getTasteId());
				e.printStackTrace();
				return "失敗 修改" + tb.getTasteId();
			}
		}
		
		public Collection<TasteBean> findByPrimaryKey(String TasteId) {

			String sql = "select * from Taste where Taste_id = ?;";

			Collection<TasteBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				
				pstmt.setString(1, TasteId);
				
				try (ResultSet rs = pstmt.executeQuery();) {
					
					while (rs.next()) {
						TasteBean tb = new TasteBean();
						tb.setTasteId(rs.getString(1));
						tb.setTasteName(rs.getString(2));
						coll.add(tb);
					}
					System.out.println("序號查詢資料");
				}
				return coll;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Collection<TasteBean> findAll() {

			String sql = "select * from Taste;";

			Collection<TasteBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

				try (ResultSet rs = pstmt.executeQuery();) {

					while (rs.next()) {
						TasteBean tb = new TasteBean();
						tb.setTasteId(rs.getString(1));
						tb.setTasteName(rs.getString(2));
						coll.add(tb);
					}
					System.out.println("記錄 查詢all");
				}
				return coll;
			} catch (Exception e) {

				e.printStackTrace();
			}
			return null;
		}
		
		public Boolean ifExist(String productId){
			
			String sql = "select * from product where product_id =?;";
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
				pstmt.setString(1, productId);
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
	}

