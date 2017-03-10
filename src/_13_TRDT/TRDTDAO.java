package _13_TRDT;

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

public class TRDTDAO {
	
	Context ctx;
	DataSource ds;

	public TRDTDAO(){

		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			e1.printStackTrace();
		}	
		try {
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/Java004NO1");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}
	
		synchronized public String insert(TRDTBean tb){
			
			String sql = "INSERT INTO TRDT "
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
					+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
					+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
					+ ", ?)";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
				){				
			
				pstmt.setString(1, tb.getCoSqe());
				pstmt.setString(2, tb.getCoType());
				pstmt.setString(3, tb.getCoRole());
				pstmt.setString(4, tb.getCoYear());
				pstmt.setString(5, tb.getCoMonth());
				pstmt.setString(6, tb.getMinRole());
				pstmt.setString(7, tb.getTrDate());
				pstmt.setString(8, tb.getProductId());
				pstmt.setString(9, tb.getTasteId());
				pstmt.setString(10, tb.getPackageId());
				pstmt.setInt(11, tb.getSeqNo());
				pstmt.setInt(12, tb.getTrQty());
				pstmt.setDouble(13, tb.getTrList());
				pstmt.setDouble(14, tb.getTrPrice());
				pstmt.setDouble(15, tb.getTrSold());
				pstmt.setDouble(16, tb.getTrCost());
				pstmt.setDouble(17, tb.getTrDiscount());
				pstmt.setDouble(18, tb.getPreDeposit());
				pstmt.setDouble(19, tb.getThisDeposit());
				pstmt.setDouble(20, tb.getVisa());
				pstmt.setDouble(21, tb.getCash());
				pstmt.setString(22, tb.getSales());
				pstmt.setString(23, tb.getShift());
				pstmt.setDouble(24, tb.getDiscAtm());
				pstmt.setString(25, tb.getMid());
				pstmt.setString(26, tb.getIuser());
				pstmt.setString(27, tb.getIdate());
				pstmt.setString(28, tb.getItime());
				pstmt.setString(29, tb.getMuser());
				pstmt.setString(30, tb.getMdate());
				pstmt.setString(31, tb.getMtime());
				pstmt.executeUpdate();
				
				System.out.println("成功 新增" + tb.getCoSqe());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 新增" + tb.getCoSqe());
				e.printStackTrace();
				return "失敗 新增" + tb.getCoSqe();
			}	
		}
		
		public boolean delete(String coSqe){
		
			String sql = "DELETE FROM TRDT WHERE Co_sqe =? ;";
			try(
					Connection con = ds.getConnection();
					PreparedStatement pstmt	= con.prepareStatement(sql);
				){
				
				pstmt.setString(1, coSqe);
				pstmt.executeUpdate();
				System.out.println("成功 刪除 "+ coSqe);
				return true;
				
			}catch (SQLException e){
				System.out.println("失敗 刪除 "+ coSqe);
				e.printStackTrace();
				return false;
			}
			
		}
		
		synchronized public String update(TRDTBean tb){
			
			String sql = "UPDATE TRDT SET ";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
				pstmt.setString(1, tb.getCoSqe());
				pstmt.setString(2, tb.getCoType());
				pstmt.setString(3, tb.getCoRole());
				pstmt.setString(4, tb.getCoYear());
				pstmt.setString(5, tb.getCoMonth());
				pstmt.setString(6, tb.getMinRole());
				pstmt.setString(7, tb.getTrDate());
				pstmt.setString(8, tb.getProductId());
				pstmt.setString(9, tb.getTasteId());
				pstmt.setString(10, tb.getPackageId());
				pstmt.setInt(11, tb.getSeqNo());
				pstmt.setInt(12, tb.getTrQty());
				pstmt.setDouble(13, tb.getTrList());
				pstmt.setDouble(14, tb.getTrPrice());
				pstmt.setDouble(15, tb.getTrSold());
				pstmt.setDouble(16, tb.getTrCost());
				pstmt.setDouble(17, tb.getTrDiscount());
				pstmt.setDouble(18, tb.getPreDeposit());
				pstmt.setDouble(19, tb.getThisDeposit());
				pstmt.setDouble(20, tb.getVisa());
				pstmt.setDouble(21, tb.getCash());
				pstmt.setString(22, tb.getSales());
				pstmt.setString(23, tb.getShift());
				pstmt.setDouble(24, tb.getDiscAtm());
				pstmt.setString(25, tb.getMid());
				pstmt.setString(26, tb.getIuser());
				pstmt.setString(27, tb.getIdate());
				pstmt.setString(28, tb.getItime());
				pstmt.setString(29, tb.getMuser());
				pstmt.setString(30, tb.getMdate());
				pstmt.setString(31, tb.getMtime());
				pstmt.executeUpdate();
				
				System.out.println("成功 修改" + tb.getCoSqe());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 修改" + tb.getCoSqe());
				e.printStackTrace();
				return "失敗 修改" + tb.getCoSqe();
			}
		}
		
		public Collection<TRDTBean> findByPrimaryKey(String coSqe) {

			String sql = "select * from TRDT where Co_sqe = ?;";

			Collection<TRDTBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				
				pstmt.setString(1, coSqe);
				
				try (ResultSet rs = pstmt.executeQuery();) {
					
					while (rs.next()) {
						TRDTBean tb = new TRDTBean();
						tb.setCoSqe(rs.getString(1));
						tb.setCoType(rs.getString(2));
						tb.setCoRole(rs.getString(3));
						tb.setCoYear(rs.getString(4));
						tb.setCoMonth(rs.getString(5));
						tb.setMinRole(rs.getString(6));
						tb.setTrDate(rs.getString(7));
						tb.setProductId(rs.getString(8));
						tb.setTasteId(rs.getString(9));
						tb.setPackageId(rs.getString(10));
						tb.setSeqNo(rs.getInt(11));
						tb.setTrQty(rs.getInt(12));
						tb.setTrList(rs.getDouble(13));
						tb.setTrPrice(rs.getDouble(14));
						tb.setTrSold(rs.getDouble(15));
						tb.setTrCost(rs.getDouble(16));
						tb.setTrDiscount(rs.getDouble(17));
						tb.setPreDeposit(rs.getDouble(18));
						tb.setThisDeposit(rs.getDouble(19));
						tb.setVisa(rs.getDouble(20));
						tb.setCash(rs.getDouble(21));
						tb.setSales(rs.getString(22));
						tb.setShift(rs.getString(23));
						tb.setDiscAtm(rs.getDouble(24));
						tb.setMid(rs.getString(25));
						tb.setIuser(rs.getString(26));
						tb.setIdate(rs.getString(27));
						tb.setItime(rs.getString(28));
						tb.setMuser(rs.getString(29));
						tb.setMdate(rs.getString(30));
						tb.setMtime(rs.getString(31));
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
		
		public Collection<TRDTBean> findAll() {

			String sql = "select * from TRDT;";

			Collection<TRDTBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

				try (ResultSet rs = pstmt.executeQuery();) {

					while (rs.next()) {
						TRDTBean tb = new TRDTBean();
						tb.setCoSqe(rs.getString(1));
						tb.setCoType(rs.getString(2));
						tb.setCoRole(rs.getString(3));
						tb.setCoYear(rs.getString(4));
						tb.setCoMonth(rs.getString(5));
						tb.setMinRole(rs.getString(6));
						tb.setTrDate(rs.getString(7));
						tb.setProductId(rs.getString(8));
						tb.setTasteId(rs.getString(9));
						tb.setPackageId(rs.getString(10));
						tb.setSeqNo(rs.getInt(11));
						tb.setTrQty(rs.getInt(12));
						tb.setTrList(rs.getDouble(13));
						tb.setTrPrice(rs.getDouble(14));
						tb.setTrSold(rs.getDouble(15));
						tb.setTrCost(rs.getDouble(16));
						tb.setTrDiscount(rs.getDouble(17));
						tb.setPreDeposit(rs.getDouble(18));
						tb.setThisDeposit(rs.getDouble(19));
						tb.setVisa(rs.getDouble(20));
						tb.setCash(rs.getDouble(21));
						tb.setSales(rs.getString(22));
						tb.setShift(rs.getString(23));
						tb.setDiscAtm(rs.getDouble(24));
						tb.setMid(rs.getString(25));
						tb.setIuser(rs.getString(26));
						tb.setIdate(rs.getString(27));
						tb.setItime(rs.getString(28));
						tb.setMuser(rs.getString(29));
						tb.setMdate(rs.getString(30));
						tb.setMtime(rs.getString(31));
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

