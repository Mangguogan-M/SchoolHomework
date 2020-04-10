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

	// 定义数据库的用户名与密码
	static final String USER = "sa";
	static final String PASS = "root";

	public myServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		Statement stmt = null;
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "单位表";
		String docType = "<!DOCTYPE html>\n";
		out.println(docType + "<html>\n" + "<head><title>" + title + "</title></head>\n"
				+ "<body bgcolor=\"#f0f0f0\" >\n" + "<h1 align=\"center\">" + title + "</h1>\n");
		out.println("<div align=\"center\">");
		out.println("<table border=\"1\">");
		out.println("<tr>\r\n" + "<th>单位编号</th>\r\n" + "<th>单位名称</th>\r\n" + "</tr>");
		try {
			// 注册 JDBC 驱动器
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			// 打开一个连接
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// 执行 SQL 查询
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT dd.单位编号,dd.单位名称 FROM 单位表 dd ";
			// sql语句更改
			ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				int id = rs.getInt("单位编号");
				String name = rs.getString("单位名称");

				// 输出数据

				out.println("<tr>\r\n" + "<td>" + id + "</td>\r\n" + "<td>" + name + "</td>\r\n" + "</tr>");

			}
			out.println("</table>");
			out.println("</div>");
			out.println("</body></html>");
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// 处理 JDBC 错误
			se.printStackTrace();
		} catch (Exception e) {
			// 处理 Class.forName 错误
			e.printStackTrace();
		} finally {
			// 最后是用于关闭资源的块
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
