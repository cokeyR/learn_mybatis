package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectTest {

	private static String USERNAMR = "wangxiang";
	private static String PASSWORD = "abcd1234";
	private static String DRVIER = "oracle.jdbc.OracleDriver";
	private static String URL = "jdbc:oracle:thin:@127.0.0.1:1521:mybatis";

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
