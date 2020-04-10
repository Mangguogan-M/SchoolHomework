<%@ page language="java" contentType="text/html; charset=utf-8"   pageEncoding="utf-8"%>
<%@ page  import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="style.css">
<title>JSP连接SQLserver数据库</title>
</head>
<body>


<%
    
    String url = "jdbc:sqlserver://localhost:1433;databaseName=study2;characterEncoding=utf-8";
    String user="sa";  //超级管理员
    String password="root";  //密码
    out.println("<div align=\"center\">");
	out.println("<span style='color:#0068B7'><table border=\"1\"></span>");
	out.println("<tr>" + "<th>教师号</th>" + "<th>姓名</th>" + "<th>性别</th>" +"</tr>");
	%>
   <%
    try {
        //1.加载驱动
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       
        //2.连接
        Connection ct=DriverManager.getConnection( url,user,password);
   
    out.println("<span style='color:red'><h1>dbo.教师表</h1></span>");    
    /*尝试查询数据库*/
    
    	Statement stmt = ct.createStatement();
    	String sql ;
    	sql = "SELECT dd.教师号,dd.姓名,dd.性别 FROM 教师表 dd ";
    	// 执行数据库查询语句
        ResultSet rs = stmt.executeQuery(sql);

			// 展开结果集数据库
			while (rs.next()) {
				// 通过字段检索
				int id = rs.getInt("教师号");
				String name = rs.getString("姓名");
				String age = rs.getString("性别");

				// 输出数据

				out.println("<tr>" + "<td>" + id + "</td>" + "<td>" + name + "</td>" +"<td>" + age + "</td>"+ "</tr>");
			}
			out.println("</table>");
			out.println("</div>");
        if (rs != null) {
            rs.close();
            rs = null;
        }
        if (stmt != null) {
            stmt.close();
            stmt = null;
        }
        if (ct != null) {
            ct.close();
            ct = null;
        }
    }
    catch (SQLException e) {
        e.printStackTrace();
        System.out.println("数据库连接失败");
    }
    
    
     %>
</body>
</html>
