package _00_Database;

public class DatabaseMain {

	public static void main(String[] args) {
		PlaceDAO pDao = new PlaceDAO();
		pDao.setCreateTables();
		pDao.setInsertUser();
		
		System.out.println("--------------------");
		System.out.println("資料庫新建完成");
	}
}
