package _22_ShoppingTrackingList;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TrackingDAO {

	Context ctx;
	DataSource ds;

	public TrackingDAO() {

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

	synchronized public String insert(TrackingBean tb) {

		String sql = "INSERT INTO Tracking " + " VALUES(? ,?)";

		try (Connection con = ds.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(sql);
			) {

			pstmt.setString(1, tb.getUsername());
			pstmt.setString(2, tb.getProducid());
			pstmt.executeUpdate();

			System.out.println("成功新增追蹤" + tb.getUsername());

			return null;
		} catch (Exception e) {
			System.out.println("儲存資料" + tb.getUsername() + "時發生錯誤，請檢查，例外=" + e.getMessage());
			e.printStackTrace();
			return "儲存資料" + tb.getUsername() + "時發生錯誤，請檢查，例外=" + e.getMessage();
		}
	}

	public boolean delete(String productId) {

		String sql = "DELETE FROM Tracking WHERE Product_id =? ;";
		try (Connection con = ds.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setString(1, productId);
			pstmt.executeUpdate();
			System.out.println("成功刪除追蹤 " + productId);
			return true;
		} catch (SQLException e) {
			System.out.println("失敗刪除追蹤 " + productId);
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean ifExist(String productId) {

		String sql = "select * from Tracking where product_id =?;";
		try (Connection con = ds.getConnection(); 
			PreparedStatement pstmt = con.prepareStatement(sql);
			) {

			pstmt.setString(1, productId);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					return true;
				} else {
					return false;
				}
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

}
