package Three.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库连接工具类
 */
public class DbUtil {
	// 数据库驱动
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// 具体数据库URL
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=study2;characterEncoding=utf-8";
	// 用户
	private static String user = "sa";
	// 密码
	private static String password = "root";
	// 数据库连接
	private static Connection conn = null;

	// 获取数据库连接
	public static Connection getConnection() {

		try {
			// 加载驱动
			Class.forName(driver);
			// 获取数据库连接
			if (conn == null) {
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println();
		getConnection();
	}

}
