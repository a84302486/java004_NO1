package _00_Database;

public class TestMain {

	public static void main(String[] args) {
		PlaceDAO pDao = new PlaceDAO();
		pDao.createTables();
	}
}