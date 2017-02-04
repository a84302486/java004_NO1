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
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/java004");
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
			
				pstmt.setString(1, tb.getCo_sqe());
				pstmt.setString(2, tb.getCo_type());
				pstmt.setString(3, tb.getCo_role());
				pstmt.setString(4, tb.getCo_year());
				pstmt.setString(5, tb.getCo_month());
				pstmt.setString(6, tb.getMin_role());
				pstmt.setString(7, tb.getTr_date());
				pstmt.setString(8, tb.getProduct_id());
				pstmt.setString(9, tb.getTaste_id());
				pstmt.setString(10, tb.getPackage_id());
				pstmt.setInt(11, tb.getSeq_no());
				pstmt.setInt(12, tb.getTr_qty());
				pstmt.setDouble(13, tb.getTr_list());
				pstmt.setDouble(14, tb.getTr_price());
				pstmt.setDouble(15, tb.getTr_sold());
				pstmt.setDouble(16, tb.getTr_cost());
				pstmt.setDouble(17, tb.getTr_discount());
				pstmt.setDouble(18, tb.getPre_deposit());
				pstmt.setDouble(19, tb.getThis_deposit());
				pstmt.setDouble(20, tb.getVisa());
				pstmt.setDouble(21, tb.getCash());
				pstmt.setString(22, tb.getSales());
				pstmt.setString(23, tb.getShift());
				pstmt.setDouble(24, tb.getDisc_atm());
				pstmt.setString(25, tb.getM_id());
				pstmt.setString(26, tb.getIuser());
				pstmt.setString(27, tb.getIdate());
				pstmt.setString(28, tb.getItime());
				pstmt.setString(29, tb.getMuser());
				pstmt.setString(30, tb.getMdate());
				pstmt.setString(31, tb.getMtime());
				pstmt.executeUpdate();
				
				System.out.println("成功 新增" + tb.getCo_sqe());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 新增" + tb.getCo_sqe());
				e.printStackTrace();
				return "失敗 新增" + tb.getCo_sqe();
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
			
				pstmt.setString(1, tb.getCo_sqe());
				pstmt.setString(2, tb.getCo_type());
				pstmt.setString(3, tb.getCo_role());
				pstmt.setString(4, tb.getCo_year());
				pstmt.setString(5, tb.getCo_month());
				pstmt.setString(6, tb.getMin_role());
				pstmt.setString(7, tb.getTr_date());
				pstmt.setString(8, tb.getProduct_id());
				pstmt.setString(9, tb.getTaste_id());
				pstmt.setString(10, tb.getPackage_id());
				pstmt.setInt(11, tb.getSeq_no());
				pstmt.setInt(12, tb.getTr_qty());
				pstmt.setDouble(13, tb.getTr_list());
				pstmt.setDouble(14, tb.getTr_price());
				pstmt.setDouble(15, tb.getTr_sold());
				pstmt.setDouble(16, tb.getTr_cost());
				pstmt.setDouble(17, tb.getTr_discount());
				pstmt.setDouble(18, tb.getPre_deposit());
				pstmt.setDouble(19, tb.getThis_deposit());
				pstmt.setDouble(20, tb.getVisa());
				pstmt.setDouble(21, tb.getCash());
				pstmt.setString(22, tb.getSales());
				pstmt.setString(23, tb.getShift());
				pstmt.setDouble(24, tb.getDisc_atm());
				pstmt.setString(25, tb.getM_id());
				pstmt.setString(26, tb.getIuser());
				pstmt.setString(27, tb.getIdate());
				pstmt.setString(28, tb.getItime());
				pstmt.setString(29, tb.getMuser());
				pstmt.setString(30, tb.getMdate());
				pstmt.setString(31, tb.getMtime());;
				pstmt.executeUpdate();
				
				System.out.println("成功 修改" + tb.getCo_sqe());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 修改" + tb.getCo_sqe());
				e.printStackTrace();
				return "失敗 修改" + tb.getCo_sqe();
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
						tb.setCo_sqe(rs.getString(1));
						tb.setCo_type(rs.getString(2));
						tb.setCo_role(rs.getString(3));
						tb.setCo_year(rs.getString(4));
						tb.setCo_month(rs.getString(5));
						tb.setMin_role(rs.getString(6));
						tb.setTr_date(rs.getString(7));
						tb.setProduct_id(rs.getString(8));
						tb.setTaste_id(rs.getString(9));
						tb.setPackage_id(rs.getString(10));
						tb.setSeq_no(rs.getInt(11));
						tb.setTr_qty(rs.getInt(12));
						tb.setTr_list(rs.getDouble(13));
						tb.setTr_price(rs.getDouble(14));
						tb.setTr_sold(rs.getDouble(15));
						tb.setTr_cost(rs.getDouble(16));
						tb.setTr_discount(rs.getDouble(17));
						tb.setPre_deposit(rs.getDouble(18));
						tb.setThis_deposit(rs.getDouble(19));
						tb.setVisa(rs.getDouble(20));
						tb.setCash(rs.getDouble(21));
						tb.setSales(rs.getString(22));
						tb.setShift(rs.getString(23));
						tb.setDisc_atm(rs.getDouble(24));
						tb.setM_id(rs.getString(25));
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
						tb.setCo_sqe(rs.getString(1));
						tb.setCo_type(rs.getString(2));
						tb.setCo_role(rs.getString(3));
						tb.setCo_year(rs.getString(4));
						tb.setCo_month(rs.getString(5));
						tb.setMin_role(rs.getString(6));
						tb.setTr_date(rs.getString(7));
						tb.setProduct_id(rs.getString(8));
						tb.setTaste_id(rs.getString(9));
						tb.setPackage_id(rs.getString(10));
						tb.setSeq_no(rs.getInt(11));
						tb.setTr_qty(rs.getInt(12));
						tb.setTr_list(rs.getDouble(13));
						tb.setTr_price(rs.getDouble(14));
						tb.setTr_sold(rs.getDouble(15));
						tb.setTr_cost(rs.getDouble(16));
						tb.setTr_discount(rs.getDouble(17));
						tb.setPre_deposit(rs.getDouble(18));
						tb.setThis_deposit(rs.getDouble(19));
						tb.setVisa(rs.getDouble(20));
						tb.setCash(rs.getDouble(21));
						tb.setSales(rs.getString(22));
						tb.setShift(rs.getString(23));
						tb.setDisc_atm(rs.getDouble(24));
						tb.setM_id(rs.getString(25));
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

