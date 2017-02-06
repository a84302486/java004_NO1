package _10_Warehouse;

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

public class WarehouseDAO {
	
	Context ctx;
	DataSource ds;

	public WarehouseDAO(){

		try {
			ctx = new InitialContext();
		} catch (NamingException e1) {
			e1.printStackTrace();
		}	
		try {
			ds = (DataSource) ctx.lookup("java:comp/env/jwbc/java004");
		} catch (NamingException e1) {
			e1.printStackTrace();
		}
	}
	
		synchronized public String insert(WarehouseBean wb){
			
			String sql = "INSERT INTO warehouse "
					+ " VALUES(null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
				){				
			
				pstmt.setInt(1, wb.getwId());
				pstmt.setString(2, wb.getCustomerId());
				pstmt.setString(3, wb.getProductId());
				pstmt.setString(4, wb.getTasteId());
				pstmt.setString(5, wb.getPackageId());
				pstmt.setInt(6, wb.getStock());
				pstmt.setInt(7, wb.getAcREC());
				pstmt.setInt(8, wb.getAcRET());
				pstmt.setInt(9, wb.getAcSAL());
				pstmt.setInt(10, wb.getAcBAD());
				pstmt.setInt(11, wb.getAcBAL());
				pstmt.setString(12, wb.getMfd());
				pstmt.executeUpdate();
				
				System.out.println("成功 新增" + wb.getwId());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 新增" + wb.getwId());
				e.printStackTrace();
				return "失敗 新增" + wb.getwId();
			}	
		}
		
		public boolean delete(String warehouseId){
		
			String sql = "DELETE FROM warehouse WHERE warehouse_id =? ;";
			try(
					Connection con = ds.getConnection();
					PreparedStatement pstmt	= con.prepareStatement(sql);
				){
				
				pstmt.setString(1, warehouseId);
				pstmt.executeUpdate();
				System.out.println("成功 刪除 "+ warehouseId);
				return true;
				
			}catch (SQLException e){
				System.out.println("失敗 刪除 "+ warehouseId);
				e.printStackTrace();
				return false;
			}
			
		}
		
		synchronized public String update(WarehouseBean wb){
			
			String sql = "UPDATE warehouse SET "
					+ "W_ID = ?, Customer_id = ?, Product_id = ?, Taste_ID = ?, Package_ID = ?, "
					+ "Stock = ?, AC_REC = ?, AC_RET = ?, AC_SAL = ?, AC_BAD = ?,"
					+ "AC_BAL = ?, MFD = ?"
					+ "WHERE warehouse_id = ?;";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
				pstmt.setInt(1, wb.getwId());
				pstmt.setString(2, wb.getCustomerId());
				pstmt.setString(3, wb.getProductId());
				pstmt.setString(4, wb.getTasteId());
				pstmt.setString(5, wb.getPackageId());
				pstmt.setInt(6, wb.getStock());
				pstmt.setInt(7, wb.getAcREC());
				pstmt.setInt(8, wb.getAcRET());
				pstmt.setInt(9, wb.getAcSAL());
				pstmt.setInt(10, wb.getAcBAD());
				pstmt.setInt(11, wb.getAcBAL());
				pstmt.setString(12, wb.getMfd());
				pstmt.executeUpdate();
				
				System.out.println("成功 修改" + wb.getwId());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 修改" + wb.getwId());
				e.printStackTrace();
				return "失敗 修改" + wb.getwId();
			}
		}
		
		public Collection<WarehouseBean> findByPrimaryKey(String warehouseId) {

			String sql = "select * from warehouse where W_ID = ?;";

			Collection<WarehouseBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				
				pstmt.setString(1, warehouseId);
				
				try (ResultSet rs = pstmt.executeQuery();) {
					
					while (rs.next()) {
						WarehouseBean wb = new WarehouseBean();
						wb.setwId(rs.getInt(1));
						wb.setCustomerId(rs.getString(2));
						wb.setProductId(rs.getString(3));
						wb.setTasteId(rs.getString(4));
						wb.setPackageId(rs.getString(5));
						wb.setStock(rs.getInt(6));
						wb.setAcREC(rs.getInt(7));
						wb.setAcRET(rs.getInt(8));
						wb.setAcSAL(rs.getInt(9));
						wb.setAcBAD(rs.getInt(10));
						wb.setAcBAL(rs.getInt(11));
						wb.setMfd(rs.getString(12));
						coll.add(wb);
					}
					System.out.println("序號查詢資料");
				}
				return coll;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Collection<WarehouseBean> findAll() {

			String sql = "select * from warehouse;";

			Collection<WarehouseBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

				try (ResultSet rs = pstmt.executeQuery();) {

					while (rs.next()) {
						WarehouseBean wb = new WarehouseBean();
						wb.setwId(rs.getInt(1));
						wb.setCustomerId(rs.getString(2));
						wb.setProductId(rs.getString(3));
						wb.setTasteId(rs.getString(4));
						wb.setPackageId(rs.getString(5));
						wb.setStock(rs.getInt(6));
						wb.setAcREC(rs.getInt(7));
						wb.setAcRET(rs.getInt(8));
						wb.setAcSAL(rs.getInt(9));
						wb.setAcBAD(rs.getInt(10));
						wb.setAcBAL(rs.getInt(11));
						wb.setMfd(rs.getString(12));
						coll.add(wb);
						coll.add(wb);
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

