package _11_StockUpdate;

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

public class StockUpdateDAO {
	
	Context ctx;
	DataSource ds;

	public StockUpdateDAO(){

		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			e1.printStackTrace();
		}	
		try {
			ds = (DataSource) ctx.lookup("java:comp/env/jsubc/java004");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}
	
		synchronized public String insert(StockUpdateBean sub){
			
			String sql = "INSERT INTO StockUpdate "
					+ " VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
				){				
			
				pstmt.setString(1, sub.getCpDate());
				pstmt.setInt(2, sub.getCpREC());
				pstmt.setInt(3, sub.getCpRET());
				pstmt.setInt(4, sub.getCpSAL());
				pstmt.setInt(5, sub.getCpBAD());
				pstmt.setInt(6, sub.getCpBAL());
				pstmt.setInt(7, sub.getEndStock());
				pstmt.setInt(8, sub.getNetStock());
				pstmt.executeUpdate();
				
				System.out.println("成功 新增" + sub.getCpDate());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 新增" + sub.getCpDate());
				e.printStackTrace();
				return "失敗 新增" + sub.getCpDate();
			}	
		}
		
		public boolean delete(String cpId){
		
			String sql = "DELETE FROM StockUpdate WHERE cp_Id =? ;";
			try(
					Connection con = ds.getConnection();
					PreparedStatement pstmt	= con.prepareStatement(sql);
				){
				
				pstmt.setString(1, cpId);
				pstmt.executeUpdate();
				System.out.println("成功 刪除 "+ cpId);
				return true;
				
			}catch (SQLException e){
				System.out.println("失敗 刪除 "+ cpId);
				e.printStackTrace();
				return false;
			}
			
		}
		
		synchronized public String update(StockUpdateBean sub){
			
			String sql = "UPDATE StockUpdate SET "
					+ "CP_Date = ?, CP_REC = ?, CP_RET = ?, CP_SAL = ?, "
					+ "CP_BAD = ?, CP_BAL = ?, End_Stock = ?, Net_Stock = ?"
					+ "WHERE warehouse_id = ?;";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
				pstmt.setString(1, sub.getCpDate());
				pstmt.setInt(2, sub.getCpREC());
				pstmt.setInt(3, sub.getCpRET());
				pstmt.setInt(4, sub.getCpSAL());
				pstmt.setInt(5, sub.getCpBAD());
				pstmt.setInt(6, sub.getCpBAL());
				pstmt.setInt(7, sub.getEndStock());
				pstmt.setInt(8, sub.getNetStock());;
				pstmt.executeUpdate();
				
				System.out.println("成功 修改" + sub.getCpDate());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 修改" + sub.getCpDate());
				e.printStackTrace();
				return "失敗 修改" + sub.getCpDate();
			}
		}
		
		public Collection<StockUpdateBean> findByPrimaryKey(String cpId) {

			String sql = "select * from StockUpdate where CP_ID = ?;";

			Collection<StockUpdateBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				
				pstmt.setString(1, cpId);
				
				try (ResultSet rs = pstmt.executeQuery();) {
					
					while (rs.next()) {
						StockUpdateBean sub = new StockUpdateBean();
						sub.setCpDate(rs.getString(1));
						sub.setCpREC(rs.getInt(2));
						sub.setCpRET(rs.getInt(3));
						sub.setCpSAL(rs.getInt(4));
						sub.setCpBAD(rs.getInt(5));
						sub.setCpBAL(rs.getInt(6));
						sub.setEndStock(rs.getInt(7));
						sub.setNetStock(rs.getInt(8));
						coll.add(sub);
					}
					System.out.println("序號查詢資料");
				}
				return coll;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Collection<StockUpdateBean> findAll() {

			String sql = "select * from warehouse;";

			Collection<StockUpdateBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

				try (ResultSet rs = pstmt.executeQuery();) {

					while (rs.next()) {
						StockUpdateBean sub = new StockUpdateBean();
						sub.setCpDate(rs.getString(1));
						sub.setCpREC(rs.getInt(2));
						sub.setCpRET(rs.getInt(3));
						sub.setCpSAL(rs.getInt(4));
						sub.setCpBAD(rs.getInt(5));
						sub.setCpBAL(rs.getInt(6));
						sub.setEndStock(rs.getInt(7));
						sub.setNetStock(rs.getInt(8));
						coll.add(sub);
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

