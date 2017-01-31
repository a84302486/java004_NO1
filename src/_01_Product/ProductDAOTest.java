package _01_Product;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import _00_Util.BeanDAO;

public class ProductDAOTest {
	public static void main(String[] args) throws SQLException {
	
		
		BeanDAO dao = new BeanDAO();
		 
		dao.pstmtSetValue(null, args, args, args);
}
}