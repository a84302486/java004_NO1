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
			
				pstmt.setString(1, tb.getCoSeq());
				pstmt.setString(2, tb.getCoType());
				pstmt.setString(3, tb.getCoRole());
				pstmt.setString(4, tb.getCoYear());
				pstmt.setString(5, tb.getCoMonth());
				pstmt.setString(6, tb.getMinRole());
				pstmt.setString(7, tb.getTrDate());
				pstmt.setDouble(8, tb.getSeqNo());
				pstmt.setDouble(9, tb.getToList());
				pstmt.setDouble(10, tb.getToPrice());
				pstmt.setDouble(11, tb.getToSold());
				pstmt.setDouble(12, tb.getToCost());
				pstmt.setDouble(13, tb.getToDisc());
				pstmt.executeUpdate();
				
				System.out.println("成功 新增" + tb.getCoSeq());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 新增" + tb.getCoSeq());
				e.printStackTrace();
				return "失敗 新增" + tb.getCoSeq();
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
			
				pstmt.setString(1, tb.getCoSeq());
				pstmt.setString(2, tb.getCoType());
				pstmt.setString(3, tb.getCoRole());
				pstmt.setString(4, tb.getCoYear());
				pstmt.setString(5, tb.getCoMonth());
				pstmt.setString(6, tb.getMinRole());
				pstmt.setString(7, tb.getTrDate());
				pstmt.setDouble(8, tb.getSeqNo());
				pstmt.setDouble(9, tb.getToList());
				pstmt.setDouble(10, tb.getToPrice());
				pstmt.setDouble(11, tb.getToSold());
				pstmt.setDouble(12, tb.getToCost());
				pstmt.setDouble(13, tb.getToDisc());
				pstmt.executeUpdate();
				
				System.out.println("成功 修改" + tb.getCoSeq());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 修改" + tb.getCoSeq());
				e.printStackTrace();
				return "失敗 修改" + tb.getCoSeq();
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
						tb.setCoSeq(rs.getString(1));
						tb.setCoType(rs.getString(2));
						tb.setCoRole(rs.getString(3));
						tb.setCoYear(rs.getString(4));
						tb.setCoMonth(rs.getString(5));
						tb.setMinRole(rs.getString(6));
						tb.setTrDate(rs.getString(7));
						tb.setSeqNo(rs.getInt(8));
						tb.setToQty(rs.getInt(9));
						tb.setToList(rs.getDouble(10));
						tb.setToPrice(rs.getInt(11));
						tb.setToSold(rs.getInt(12));
						tb.setToCost(rs.getDouble(13));
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
						tb.setCoSeq(rs.getString(1));
						tb.setCoType(rs.getString(2));
						tb.setCoRole(rs.getString(3));
						tb.setCoYear(rs.getString(4));
						tb.setCoMonth(rs.getString(5));
						tb.setMinRole(rs.getString(6));
						tb.setTrDate(rs.getString(7));
						tb.setSeqNo(rs.getInt(8));
						tb.setToQty(rs.getInt(9));
						tb.setToList(rs.getDouble(10));
						tb.setToPrice(rs.getInt(11));
						tb.setToSold(rs.getInt(12));
						tb.setToCost(rs.getDouble(13));
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

