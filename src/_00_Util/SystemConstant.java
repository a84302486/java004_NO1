package _00_Util;

public class SystemConstant {
	public static final int    RECORDS_PER_PAGE = 13;
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
    public static final String HOST = "127.0.0.1";
    public static final String DB = "Java004NO1";
    public static final String USER = "root";
<<<<<<< HEAD
    public static final String PASSWORD = "215060";
=======
    public static final String PASSWORD = "password";

>>>>>>> 9c69e78be1c01e6f5cd0337079a89c85a6578c72
    public static final String URL = "jdbc:mysql://" + HOST + ":3306/" + SystemConstant.DB
			+ "?user=" + SystemConstant.USER + "&password="
			+ SystemConstant.PASSWORD + "&useSSL=true&useUnicode=yes&characterEncoding=UTF-8";
}




