package MySecondServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myServlet")
public class myServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=study2;characterEncoding=utf-8";

	// �������ݿ���û���������
	static final String USER = "sa";
	static final String PASS = "root";

	public myServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		// ������Ӧ��������
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "��λ��";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\" >\n" + "<h1 align=\"center\">" + title + "</h1>\n");
		out.println("<div align=\"center\">");
		out.println("<table border=\"1\">");
		out.println("<tr>\r\n" + "<th>��λ���</th>\r\n" + "<th>��λ����</th>\r\n" + "</tr>");
		try {
			// ע�� JDBC ������
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// ��һ������
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// ִ�� SQL ��ѯ
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT dd.��λ���,dd.��λ���� FROM ��λ�� dd ";
			// sql������
			ResultSet rs = stmt.executeQuery(sql);

			// չ����������ݿ�
			while (rs.next()) {
				// ͨ���ֶμ���
				int id = rs.getInt("��λ���");
				String name = rs.getString("��λ����");

				// �������

				out.println("<tr>\r\n" + "<td>" + id + "</td>\r\n" + "<td>" + name + "</td>\r\n" + "</tr>");

			}
			out.println("</table>");
			out.println("</div>");
			out.println("</body></html>");
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// ���� JDBC ����
			se.printStackTrace();
		} catch (Exception e) {
			// ���� Class.forName ����
			e.printStackTrace();
		} finally {
			// ��������ڹر���Դ�Ŀ�
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
