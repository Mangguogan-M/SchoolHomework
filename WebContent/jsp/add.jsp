<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师信息录入</title>
<link rel="stylesheet" type="text/css" href="css/css.css">
<script src="js/formcheck.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>
</head>
<body style="padding-top: 20px;">
	<div>
		<h1 align=center>添加教师</h1>
		<br>
		<form action="add" method="post" onsubmit="return validateForm()">
			<table border="1" align="center" width="35%">
				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>编号</label></td>
					<td align="left"><input type="text" class="form-control"
						id="teacher_id" name="teacher_id" onblur="checkId()"><span
						id="checktext1">${id}开始</span></td>
				</tr>
				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>姓名</label></td>
					<td align="left"><input type="text" class="form-control"
						name="teacher_name" id="teacher_name" onblur="checkName()"><span
						id="checktext2">请输入正确姓名</span></td>

				</tr>
				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>性别</label></td>
					<td><input type="radio" name="teacher_gendar" value="男"
						checked>男 <input type="radio" name="teacher_gendar"
						value="女">女
				</tr>
				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>学位</label></td>
					<td align="left"><input type="text" class="form-control"
						name="teacher_degree" id="teacher_degree" onblur="checkDegree()"><span
						id="checktext4">学士、硕士、博士....</span></td>
				</tr>
				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>职称</label></td>
					<td align="center"><select name="teacher_jobtitle" size="1">
							<option value="教授" selected="selected">教授</option>
							<option value="副教授">副教授</option>
							<option value="助教">助教</option>
							<option value="高级助教">高级助教</option>
							<option value="经济师">经济师</option>
							<option value="高级经济师">高级经济师</option>
							<option value="研究员">研究员</option>
							<option value="讲师">讲师</option>
							<option value="助理教师">助理教师</option>
							<option value="副研究员">副研究员</option>
							<option value="助理经济师">助理经济师</option>
							<option value="工程师">工程师</option>
							<option value="实验师">实验师</option>
							<option value="助理实验师">助理实验师</option>
							<option value="高级实验师">高级实验师</option>
					</select></td>
				</tr>
				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>年龄</label></td>
					<td align="left"><input type="text" class="form-control"
						name="teacher_age" id="teacher_age" onblur="checkAge()"><span
						id="checktext6">数字0~120</span></td>
				</tr>
				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>部门</label></td>
					<td><select name="deptno" size="1">
							<c:forEach items="${dept}" var="dept">
								<option value="${dept.deptno}">${dept.dept_name}</option>
							</c:forEach>
					</select>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<button type="submit" id="nbutton">添加教师</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>