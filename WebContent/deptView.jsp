<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="java.io.PrintWriter"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<div align="center">
	<td>单位表</td>
	<table border="1">
		<tr>
			<td width="200" number="title">单位编号</td>
			<td width="200" name="title">单位名称</td>

		</tr>

		<%
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectDB = "jdbc:sqlserver://localhost:1433;DatabaseName=study2";
			String user = "sa";
			String password = "root";
			Connection con = DriverManager.getConnection(connectDB, user, password);
			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM dbo.单位表");

			while (rs.next()) {
		%>
		<tr>
			<td width="200"><%=rs.getString("单位编号")%></td>
			<td width="200"><%=rs.getString("单位名称")%></td>
		</tr>
		<%
			}
		%>
	</table>
	</body>
</html>
