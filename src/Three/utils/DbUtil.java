package Three.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���ݿ����ӹ�����
 */
public class DbUtil {
	// ���ݿ�����
	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	// �������ݿ�URL
	private static String url = "jdbc:sqlserver://localhost:1433;databaseName=study2;characterEncoding=utf-8";
	// �û�
	private static String user = "sa";
	// ����
	private static String password = "root";
	// ���ݿ�����
	private static Connection conn = null;

	// ��ȡ���ݿ�����
	public static Connection getConnection() {

		try {
			// ��������
			Class.forName(driver);
			// ��ȡ���ݿ�����
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
