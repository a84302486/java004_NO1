package _06_Supplier;

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

public class SupplierDAO {
	
	Context ctx;
	DataSource ds;

	public SupplierDAO(){

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
	
		synchronized public String insert(SupplierBean sb){
			
			String sql = "INSERT INTO Supplier "
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
				){				
			
				pstmt.setString(1, sb.getSupplierId());
				pstmt.setString(2, sb.getName());
				pstmt.setString(3, sb.getTelephone());
				pstmt.setString(4, sb.getZipNo());
				pstmt.setString(5, sb.getAddress());
				pstmt.setString(6, sb.getFax());
				pstmt.setString(7, sb.getEmail());
				pstmt.setString(8, sb.getUrl());
				pstmt.setString(9, sb.getPrincipalName());
				pstmt.setString(10, sb.getContactName());
				pstmt.executeUpdate();
				
				System.out.println("成功 新增" + sb.getSupplierId());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 新增" + sb.getSupplierId());
				e.printStackTrace();
				return "失敗 新增" + sb.getSupplierId();
			}	
		}
		
		public boolean delete(String SupplierId){
		
			String sql = "DELETE FROM Supplier WHERE Supplier_id =? ;";
			try(
					Connection con = ds.getConnection();
					PreparedStatement pstmt	= con.prepareStatement(sql);
				){
				
				pstmt.setString(1, SupplierId);
				pstmt.executeUpdate();
				System.out.println("成功 刪除 "+ SupplierId);
				return true;
				
			}catch (SQLException e){
				System.out.println("失敗 刪除 "+ SupplierId);
				e.printStackTrace();
				return false;
			}
			
		}
		
		synchronized public String update(SupplierBean sb){
			
			String sql = "UPDATE Supplier SET "
					+ "Supplier_id = ?, Name = ?, Telephone = ?, ZipNo = ?, "
					+ "Address = ?, Fax = ?, Email = ?, URL = ?, Principal_Name = ?,"
					+ "Contact_Name = ? WHERE Supplier_id = ?;";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
				pstmt.setString(1, sb.getSupplierId());
				pstmt.setString(2, sb.getName());
				pstmt.setString(3, sb.getTelephone());
				pstmt.setString(4, sb.getZipNo());
				pstmt.setString(5, sb.getAddress());
				pstmt.setString(6, sb.getFax());
				pstmt.setString(7, sb.getEmail());
				pstmt.setString(8, sb.getUrl());
				pstmt.setString(9, sb.getPrincipalName());
				pstmt.setString(10, sb.getContactName());
				pstmt.executeUpdate();
				
				System.out.println("成功 修改" + sb.getSupplierId());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 修改" + sb.getSupplierId());
				e.printStackTrace();
				return "失敗 修改" + sb.getSupplierId();
			}
		}
		
		public Collection<SupplierBean> findByPrimaryKey(String SupplierId) {

			String sql = "select * from Supplier where Supplier_id = ?;";

			Collection<SupplierBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				
				pstmt.setString(1, SupplierId);
				
				try (ResultSet rs = pstmt.executeQuery();) {
					
					while (rs.next()) {
						SupplierBean sb = new SupplierBean();
						sb.setSupplierId(rs.getString(1));
						sb.setName(rs.getString(2));
						sb.setTelephone(rs.getString(3));
						sb.setZipNo(rs.getString(4));
						sb.setAddress(rs.getString(5));
						sb.setFax(rs.getString(6));
						sb.setEmail(rs.getString(7));
						sb.setUrl(rs.getString(8));
						sb.setPrincipalName(rs.getString(9));
						sb.setContactName(rs.getString(10));
						coll.add(sb);
					}
					System.out.println("序號查詢資料");
				}
				return coll;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Collection<SupplierBean> findAll() {

			String sql = "select * from Supplier;";

			Collection<SupplierBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

				try (ResultSet rs = pstmt.executeQuery();) {

					while (rs.next()) {
						SupplierBean sb = new SupplierBean();
						sb.setSupplierId(rs.getString(1));
						sb.setName(rs.getString(2));
						sb.setTelephone(rs.getString(3));
						sb.setZipNo(rs.getString(4));
						sb.setAddress(rs.getString(5));
						sb.setFax(rs.getString(6));
						sb.setEmail(rs.getString(7));
						sb.setUrl(rs.getString(8));
						sb.setPrincipalName(rs.getString(9));
						sb.setContactName(rs.getString(10));
						coll.add(sb);
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

