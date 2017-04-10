package _05_Stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class StockDAO {

	Context ctx;
	DataSource ds;

	public StockDAO() {

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

	synchronized public String insert(StockBean sb) {

		String sql = "INSERT INTO Stock " + " VALUES(? , ? , ? , ? , ?)";

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, sb.getStockId());
			pstmt.setString(2, sb.getProductId());
			pstmt.setString(3, sb.getMfg());
			pstmt.setString(4, sb.getExp());
			pstmt.setInt(5, sb.getQuantity());
			pstmt.executeUpdate();

			System.out.println("成功 新增" + sb.getProductId());

			return null;
		} catch (Exception e) {
			System.out.println("失敗 新增" + sb.getProductId());
			e.printStackTrace();
			return "失敗 新增" + sb.getProductId();
		}
	}

	public boolean delete(String StockId) {

		String sql = "DELETE FROM stock WHERE StockId=?;";
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, StockId);
			pstmt.executeUpdate();
			System.out.println("成功 刪除 " + StockId);
			return true;
		} catch (SQLException e) {
			System.out.println("失敗 刪除 " + StockId);
			e.printStackTrace();
			return false;
		}

	}

	public Collection<StockBean> findByPrimaryKey(String ProductId) {

		String sql = "select * from Stock where Product_id = ?;";

		Collection<StockBean> coll = new ArrayList<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, ProductId);

			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					StockBean sb = new StockBean();
					sb.setStockId(rs.getString(1));
					sb.setProductId(rs.getString(2));
					sb.setMfg(rs.getString(3));
					sb.setExp(rs.getString(4));
					sb.setQuantity(rs.getInt(5));
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

	public Collection<StockBean> findAll() {

		String sql = "select * from Stock;";

		Collection<StockBean> coll = new ArrayList<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					StockBean sb = new StockBean();
					sb.setStockId(rs.getString(1));
					sb.setProductId(rs.getString(2));
					sb.setMfg(rs.getString(3));
					sb.setExp(rs.getString(4));
					sb.setQuantity(rs.getInt(5));
					coll.add(sb);
					;
				}
				System.out.println("記錄 查詢all");
			}
			return coll;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<StockBean> findByMFG(String mfg) {

		String sql = "select * from Stock where MFG = ?;";

		List<StockBean> coll = new ArrayList<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, mfg);

			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					StockBean sb = new StockBean();
					sb.setStockId(rs.getString(1));
					sb.setProductId(rs.getString(2));
					sb.setMfg(rs.getString(3));
					sb.setExp(rs.getString(4));
					sb.setQuantity(rs.getInt(5));
					coll.add(sb);
					;
				}
				System.out.println("記錄查詢MFG=" + mfg);
			}
			return coll;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public List<StockBean> findByEXP(String exp) {

		String sql = "select * from Stock where EXP = ?;";

		List<StockBean> coll = new ArrayList<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, exp);

			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					StockBean sb = new StockBean();
					sb.setStockId(rs.getString(1));
					sb.setProductId(rs.getString(2));
					sb.setMfg(rs.getString(3));
					sb.setExp(rs.getString(4));
					sb.setQuantity(rs.getInt(5));
					coll.add(sb);
					;
				}
				System.out.println("記錄查詢EXP=" + exp);
			}
			return coll;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public int getProductLife(String ProductId) {

		String sql = "select S_life from product where Product_id = ?;";

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, ProductId);
			int life = 0;
			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					life = rs.getInt(1);
				}
				System.out.println("序號查詢資料");
			}
			return life;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int getProductStock(String ProductId) {

		String sql = "select sum(quantity) from stock where product_id = ?;";

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, ProductId);
			int quantity = 0;
			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					quantity = rs.getInt(1);
				}
				System.out.println("序號查詢資料");
			}
			return quantity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
<<<<<<< HEAD
	
	
=======

>>>>>>> 9febb812a503b40823a5bdbbfc1caf66474a24d9
	public List<StockBean> findEXPOverDue() {
		String sql = "select * from Stock where datediff(EXP,curdate()) < 7;";

		List<StockBean> coll = new ArrayList<>();
		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			try (ResultSet rs = pstmt.executeQuery();) {

				while (rs.next()) {
					StockBean sb = new StockBean();
					sb.setStockId(rs.getString(1));
					sb.setProductId(rs.getString(2));
					sb.setMfg(rs.getString(3));
					sb.setExp(rs.getString(4));
					sb.setQuantity(rs.getInt(5));
					coll.add(sb);
					;
				}
				System.out.println("查詢EXP小於七天");
			}
			return coll;
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	public void updateStock(String productId) {

		String sql = "UPDATE `Stock` SET `product_stock`.`quantity`=(SELECT SUM(`product_stock`.quantity*IF(status = '-',-1,1)) From `product_stock`) where `product_id`= ?;";

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, productId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	synchronized public String insertProductStock(Product_Stock_Bean ps){
	
		String sql = "INSERT INTO `Product_Stock` VALUES(? , ? , ? , ? , ?)";

		try (Connection con = ds.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, ps.getProduct_Stock_id());
			pstmt.setString(2, ps.getProduct_id());
			pstmt.setInt(3, ps.getQuantity());
			pstmt.setString(4, ps.getStatus());
			pstmt.setString(5, ps.getInsertdate());
			pstmt.executeUpdate();

			System.out.println("成功 新增" + ps.getProduct_Stock_id());

			return null;
		} catch (Exception e) {
			System.out.println("失敗 新增" + ps.getProduct_Stock_id());
			e.printStackTrace();
			return "失敗 新增" + ps.getProduct_Stock_id();
		}
	}
	
}
