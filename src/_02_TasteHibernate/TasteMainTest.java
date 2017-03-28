package _02_TasteHibernate;

public class TasteMainTest {

	public static void main(String[] args) {
		TasteHibernateDAO dao = new TasteHibernateDAO();
		TasteBean tbInsert = new TasteBean( "002" , "辣味");
		dao.insert(tbInsert);

	}

}
