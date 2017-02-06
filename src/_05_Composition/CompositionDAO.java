package _05_Composition;

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

public class CompositionDAO {
	
	Context ctx;
	DataSource ds;

	public CompositionDAO(){

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
	
		synchronized public String insert(CompositionBean cb){
			
			String sql = "INSERT INTO Composition "
					+ " VALUES(? , ? , ?)";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
				){				
			
				pstmt.setString(1, cb.getComType());
				pstmt.setString(2, cb.getComId());
				pstmt.setString(3, cb.getComDescription());
				pstmt.executeUpdate();
				
				System.out.println("成功 新增" + cb.getComType());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 新增" + cb.getComType());
				e.printStackTrace();
				return "失敗 新增" + cb.getComType();
			}	
		}
		
		public boolean delete(String compositionType){
		
			String sql = "DELETE FROM Composition WHERE Composition_type =? ;";
			try(
					Connection con = ds.getConnection();
					PreparedStatement pstmt	= con.prepareStatement(sql);
				){
				
				pstmt.setString(1, compositionType);
				pstmt.executeUpdate();
				System.out.println("成功 刪除 "+ compositionType);
				return true;
				
			}catch (SQLException e){
				System.out.println("失敗 刪除 "+ compositionType);
				e.printStackTrace();
				return false;
			}
			
		}
		
		synchronized public String update(CompositionBean cb){
			
			String sql = "UPDATE composition SET "
					+ "Composition_id = ?, Composition_name = ? WHERE Composition_id = ?;";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
				pstmt.setString(1, cb.getComType());
				pstmt.setString(2, cb.getComId());
				pstmt.setString(3, cb.getComDescription());
				pstmt.executeUpdate();
				
				System.out.println("成功 修改" + cb.getComType());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 修改" + cb.getComType());
				e.printStackTrace();
				return "失敗 修改" + cb.getComType();
			}
		}
		
		public Collection<CompositionBean> findByPrimaryKey(String compositionType) {

			String sql = "select * from Composition where Com_type = ?;";

			Collection<CompositionBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				
				pstmt.setString(1, compositionType);
				
				try (ResultSet rs = pstmt.executeQuery();) {
					
					while (rs.next()) {
						CompositionBean cb = new CompositionBean();
						cb.setComType(rs.getString(1));
						cb.setComId(rs.getString(2));
						cb.setComDescription(rs.getString(3));
						coll.add(cb);
					}
					System.out.println("類型查詢資料");
				}
				return coll;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Collection<CompositionBean> findAll() {

			String sql = "select * from Composition;";

			Collection<CompositionBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

				try (ResultSet rs = pstmt.executeQuery();) {

					while (rs.next()) {
						CompositionBean cb = new CompositionBean();
						cb.setComType(rs.getString(1));
						cb.setComId(rs.getString(2));
						cb.setComDescription(rs.getString(3));
						coll.add(cb);
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

