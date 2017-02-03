package _00_Database;

public class DatabaseMain {

	public static void main(String[] args) {
		PlaceDAO pDao = new PlaceDAO();
		pDao.createTables();
	}
}
