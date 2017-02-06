package _09_Commission;

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

public class CommissionDAO {
	
	Context ctx;
	DataSource ds;

	public CommissionDAO(){

		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			e1.printStackTrace();
		}	
		try {
			ds = (DataSource) ctx.lookup("java:comp/env/jcbc/java004");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}
	
		synchronized public String insert(CommissionBean cb){
			
			String sql = "INSERT INTO commission "
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
					+ "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
					+ "?)";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
				){				
			
				pstmt.setInt(1, cb.getCommissionId());
				pstmt.setString(2, cb.getCustomerId());
				pstmt.setDouble(3, cb.getDiscount01());
				pstmt.setDouble(4, cb.getDiscount02());
				pstmt.setDouble(5, cb.getDiscount03());
				pstmt.setDouble(6, cb.getDiscount04());
				pstmt.setDouble(7, cb.getDiscount05());
				pstmt.setDouble(8, cb.getDiscount06());
				pstmt.setDouble(9, cb.getDiscount07());
				pstmt.setDouble(10, cb.getDiscount08());
				pstmt.setDouble(11, cb.getDiscount09());
				pstmt.setDouble(12, cb.getDiscount10());
				pstmt.setDouble(13, cb.getRate01());
				pstmt.setDouble(14, cb.getRate02());
				pstmt.setDouble(15, cb.getRate03());
				pstmt.setDouble(16, cb.getRate04());
				pstmt.setDouble(17, cb.getRate05());
				pstmt.setDouble(18, cb.getRate06());
				pstmt.setDouble(19, cb.getRate07());
				pstmt.setDouble(20, cb.getRate08());
				pstmt.setDouble(21, cb.getRate09());
				pstmt.setDouble(22, cb.getRate10());
				pstmt.executeUpdate();
				
				System.out.println("成功 新增" + cb.getCommissionId());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 新增" + cb.getCommissionId());
				e.printStackTrace();
				return "失敗 新增" + cb.getCommissionId();
			}	
		}
		
		public boolean delete(String commissionId){
		
			String sql = "DELETE FROM commission WHERE commission_id =? ;";
			try(
					Connection con = ds.getConnection();
					PreparedStatement pstmt	= con.prepareStatement(sql);
				){
				
				pstmt.setString(1, commissionId);
				pstmt.executeUpdate();
				System.out.println("成功 刪除 "+ commissionId);
				return true;
				
			}catch (SQLException e){
				System.out.println("失敗 刪除 "+ commissionId);
				e.printStackTrace();
				return false;
			}
			
		}
		
		synchronized public String update(CommissionBean cb){
			
			String sql = "UPDATE commission SET "
					+ "commission_id = ?, description = ? WHERE commission_id = ?;";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
				pstmt.setInt(1, cb.getCommissionId());
				pstmt.setString(2, cb.getCustomerId());
				pstmt.setDouble(3, cb.getDiscount01());
				pstmt.setDouble(4, cb.getDiscount02());
				pstmt.setDouble(5, cb.getDiscount03());
				pstmt.setDouble(6, cb.getDiscount04());
				pstmt.setDouble(7, cb.getDiscount05());
				pstmt.setDouble(8, cb.getDiscount06());
				pstmt.setDouble(9, cb.getDiscount07());
				pstmt.setDouble(10, cb.getDiscount08());
				pstmt.setDouble(11, cb.getDiscount09());
				pstmt.setDouble(12, cb.getDiscount10());
				pstmt.setDouble(13, cb.getRate01());
				pstmt.setDouble(14, cb.getRate02());
				pstmt.setDouble(15, cb.getRate03());
				pstmt.setDouble(16, cb.getRate04());
				pstmt.setDouble(17, cb.getRate05());
				pstmt.setDouble(18, cb.getRate06());
				pstmt.setDouble(19, cb.getRate07());
				pstmt.setDouble(20, cb.getRate08());
				pstmt.setDouble(21, cb.getRate09());
				pstmt.setDouble(22, cb.getRate10());
				pstmt.executeUpdate();
				
				System.out.println("成功 修改" + cb.getCommissionId());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 修改" + cb.getCommissionId());
				e.printStackTrace();
				return "失敗 修改" + cb.getCommissionId();
			}
		}
		
		public Collection<CommissionBean> findByPrimaryKey(String commissionId) {

			String sql = "select * from commission where commission_id = ?;";

			Collection<CommissionBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				
				pstmt.setString(1, commissionId);
				
				try (ResultSet rs = pstmt.executeQuery();) {
					
					while (rs.next()) {
						CommissionBean cb = new CommissionBean();
						cb.setCommissionId(rs.getInt(1));
						cb.setCustomerId(rs.getString(2));
						coll.add(cb);
					}
					System.out.println("序號查詢資料");
				}
				return coll;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Collection<CommissionBean> findAll() {

			String sql = "select * from commission;";

			Collection<CommissionBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

				try (ResultSet rs = pstmt.executeQuery();) {

					while (rs.next()) {
						CommissionBean cb = new CommissionBean();
						cb.setCommissionId(rs.getInt(1));
						cb.setCustomerId(rs.getString(2));
						coll.add(cb);
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

