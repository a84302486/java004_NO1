package _12_TRHD;

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

public class TRHDDAO {
	
	Context ctx;
	DataSource ds;

	public TRHDDAO(){

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
	
		synchronized public String insert(TRHDBean tb){
			
			String sql = "INSERT INTO TRDT "
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
					+ ", ?, ?, ?)";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
				){				
			
				pstmt.setString(1, tb.getCo_seq());
				pstmt.setString(2, tb.getCo_type());
				pstmt.setString(3, tb.getCo_role());
				pstmt.setString(4, tb.getCo_year());
				pstmt.setString(5, tb.getCo_month());
				pstmt.setString(6, tb.getMin_role());
				pstmt.setString(7, tb.getTr_date());
				pstmt.setDouble(8, tb.getSeq_no());
				pstmt.setDouble(9, tb.getTo_list());
				pstmt.setDouble(10, tb.getTo_price());
				pstmt.setDouble(11, tb.getTo_sold());
				pstmt.setDouble(12, tb.getTo_cost());
				pstmt.setDouble(13, tb.getTo_disc());
				pstmt.executeUpdate();
				
				System.out.println("成功 新增" + tb.getCo_seq());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 新增" + tb.getCo_seq());
				e.printStackTrace();
				return "失敗 新增" + tb.getCo_seq();
			}	
		}
		
		public boolean delete(String coSeq){
		
			String sql = "DELETE FROM TRHD WHERE co_seq =? ;";
			try(
					Connection con = ds.getConnection();
					PreparedStatement pstmt	= con.prepareStatement(sql);
				){
				
				pstmt.setString(1, coSeq);
				pstmt.executeUpdate();
				System.out.println("成功 刪除 "+ coSeq);
				return true;
				
			}catch (SQLException e){
				System.out.println("失敗 刪除 "+ coSeq);
				e.printStackTrace();
				return false;
			}
			
		}
		
		synchronized public String update(TRHDBean tb){
			
			String sql = "UPDATE TRDT SET ";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
				pstmt.setString(1, tb.getCo_seq());
				pstmt.setString(2, tb.getCo_type());
				pstmt.setString(3, tb.getCo_role());
				pstmt.setString(4, tb.getCo_year());
				pstmt.setString(5, tb.getCo_month());
				pstmt.setString(6, tb.getMin_role());
				pstmt.setString(7, tb.getTr_date());
				pstmt.setDouble(8, tb.getSeq_no());
				pstmt.setDouble(9, tb.getTo_list());
				pstmt.setDouble(10, tb.getTo_price());
				pstmt.setDouble(11, tb.getTo_sold());
				pstmt.setDouble(12, tb.getTo_cost());
				pstmt.setDouble(13, tb.getTo_disc());
				pstmt.executeUpdate();
				
				System.out.println("成功 修改" + tb.getCo_seq());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 修改" + tb.getCo_seq());
				e.printStackTrace();
				return "失敗 修改" + tb.getCo_seq();
			}
		}
		
		public Collection<TRHDBean> findByPrimaryKey(String coSeq) {

			String sql = "select * from TRDT where Co_sqe = ?;";

			Collection<TRHDBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				
				pstmt.setString(1, coSeq);
				
				try (ResultSet rs = pstmt.executeQuery();) {
					
					while (rs.next()) {
						TRHDBean tb = new TRHDBean();
						tb.setCo_seq(rs.getString(1));
						tb.setCo_type(rs.getString(2));
						tb.setCo_role(rs.getString(3));
						tb.setCo_year(rs.getString(4));
						tb.setCo_month(rs.getString(5));
						tb.setMin_role(rs.getString(6));
						tb.setTr_date(rs.getString(7));
						tb.setSeq_no(rs.getInt(8));
						tb.setTo_qty(rs.getInt(9));
						tb.setTo_list(rs.getDouble(10));
						tb.setTo_price(rs.getInt(11));
						tb.setTo_sold(rs.getInt(12));
						tb.setTo_cost(rs.getDouble(13));
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
		
		public Collection<TRHDBean> findAll() {

			String sql = "select * from TRHD;";

			Collection<TRHDBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

				try (ResultSet rs = pstmt.executeQuery();) {

					while (rs.next()) {
						TRHDBean tb = new TRHDBean();
						tb.setCo_seq(rs.getString(1));
						tb.setCo_type(rs.getString(2));
						tb.setCo_role(rs.getString(3));
						tb.setCo_year(rs.getString(4));
						tb.setCo_month(rs.getString(5));
						tb.setMin_role(rs.getString(6));
						tb.setTr_date(rs.getString(7));
						tb.setSeq_no(rs.getInt(8));
						tb.setTo_qty(rs.getInt(9));
						tb.setTo_list(rs.getDouble(10));
						tb.setTo_price(rs.getInt(11));
						tb.setTo_sold(rs.getInt(12));
						tb.setTo_cost(rs.getDouble(13));
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
	}

