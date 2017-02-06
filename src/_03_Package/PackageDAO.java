package _03_Package;

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

public class PackageDAO {
	
	Context ctx;
	DataSource ds;

	public PackageDAO(){

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
	
		synchronized public String insert(PackageBean pb){
			
			String sql = "INSERT INTO Package "
					+ " VALUES(? , ?)";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);
				){				
			
				pstmt.setString(1, pb.getPackageId());
				pstmt.setString(2, pb.getPackageName());
				pstmt.executeUpdate();
				
				System.out.println("成功 新增" + pb.getPackageId());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 新增" + pb.getPackageId());
				e.printStackTrace();
				return "失敗 新增" + pb.getPackageId();
			}	
		}
		
		public boolean delete(String PackageId){
		
			String sql = "DELETE FROM Package WHERE Package_id =? ;";
			try(
					Connection con = ds.getConnection();
					PreparedStatement pstmt	= con.prepareStatement(sql);
				){
				
				pstmt.setString(1, PackageId);
				pstmt.executeUpdate();
				System.out.println("成功 刪除 "+ PackageId);
				return true;
			}catch (SQLException e){
				System.out.println("失敗 刪除 "+ PackageId);
				e.printStackTrace();
				return false;
			}
			
		}
		
		synchronized public String update(PackageBean pb){
			
			String sql = "UPDATE Package SET "
					+ "Package_id = ?, Package_name = ? WHERE Package_id = ?;";
			
			try(
				Connection con = ds.getConnection();
				PreparedStatement pstmt	= con.prepareStatement(sql);){				
			
				pstmt.setString(1, pb.getPackageId());
				pstmt.setString(2, pb.getPackageName());	
				pstmt.executeUpdate();
				
				System.out.println("成功 修改" + pb.getPackageId());
				
				return null;
			}catch (Exception e){		
				System.out.println("失敗 修改" + pb.getPackageId());
				e.printStackTrace();
				return "失敗 修改" + pb.getPackageId();
			}
		}
		
		public Collection<PackageBean> findByPrimaryKey(String PackageId) {

			String sql = "select * from Package where Package_id = ?;";

			Collection<PackageBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
				
				pstmt.setString(1, PackageId);
				
				try (ResultSet rs = pstmt.executeQuery();) {
					
					while (rs.next()) {
						PackageBean pb = new PackageBean();
						pb.setPackageId(rs.getString(1));
						pb.setPackageName(rs.getString(2));
						coll.add(pb);
					}
					System.out.println("序號查詢資料");
				}
				return coll;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		public Collection<PackageBean> findAll() {

			String sql = "select * from Package;";

			Collection<PackageBean> coll = new ArrayList<>();
			try (Connection con = ds.getConnection(); 
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

				try (ResultSet rs = pstmt.executeQuery();) {

					while (rs.next()) {
						PackageBean pb = new PackageBean();
						pb.setPackageId(rs.getString(1));
						pb.setPackageName(rs.getString(2));
						coll.add(pb);
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

