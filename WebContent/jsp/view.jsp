<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<script type="text/javascript">
		function confirmDel(param) {
			if (window.confirm("您确定要删除该信息吗？")) {
				document.location = "delete?teacher_id=" + param
			}
		}
	</script>
<head>
<meta charset="utf-8">
<title>教师信息</title>
<link rel="stylesheet" type="text/css" href="css/css.css">
<!-- <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> -->
</head>
<body style="padding-top: 20px;">
	<div class="container">
		<h1 align=center>教师信息</h1>
		<button onclick="window.location.href='add'" id="nbutton">新增教师</button>
		<table class="table">
			<thead>
				<td style="width: 50px">编号</td>
				<td style="width: 50px">姓名</td>
				<td style="width: 50px">性别</td>
				<td style="width: 50px">学位</td>
				<td style="width: 50px">等级</td>
				<td style="width: 50px">年龄</td>
				<td style="width: 50px">部门</td>
				<td style="width: 150px">操作</td>
			</thead>
			<tbody>
				<c:forEach items="${teacher}" var="tea">
					<tr>
						<td>${tea.teacher_id}</td>
						<td>${tea.teacher_name}</td>
						<td>${tea.teacher_gendar}</td>
						<td>${tea.teacher_degree}</td>
						<td>${tea.teacher_jobtitle}</td>
						<td>${tea.teacher_age}</td>
						<td>${tea.dept}</td>
						<td><a href="update?teacher_id=${tea.teacher_id}">修改</a> <a
							onclick="confirmDel(${tea.teacher_id})">删除</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>