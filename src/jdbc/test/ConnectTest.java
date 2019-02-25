package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectTest {

	private static String USERNAMR = "wangxiang";
	private static String PASSWORD = "abcd1234";
	private static String DRVIER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8";

public static void main(String[] args) {
	    // 创建一个数据库连接
	    @SuppressWarnings("unused")
		Connection connection = null; 
	    try {
            Class.forName(DRVIER);
            connection = DriverManager.getConnection(URL, USERNAMR, PASSWORD);
            System.out.println("成功连接数据库");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("class not find !", e);
        } catch (SQLException e) {
            throw new RuntimeException("get connection error!", e);
        }
	}
}
