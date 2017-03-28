package _03_PackageHibernate;

public class PackageMainTest {

	public static void main(String[] args) {
		PackageHibernateDAO dao = new  PackageHibernateDAO();
		PackageBean tbInsert = new  PackageBean( "001" , "大包");
		dao.insert(tbInsert);

	}

}
