<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>教师信息修改</title>
<link rel="stylesheet" type="text/css" href="css/css.css">
<script src="js/updatecheck.js"></script>
<script src="js/jquery-3.2.1.min.js"></script>
</head>
<body style="padding-top: 20px;">
	<div>
		<h1 align=center>修改教师</h1>
		<br>
		<form action="update" method="post" onsubmit="return validateForm()">
			<table border="1" align="center" width="35%">
				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>编号</label></td>
					<td align="left"><input type="text" class="form-control"
						id="teacher_id" name="teacher_id" readonly="readonly"
						value=${teacher.teacher_id}><span id="checktext1">编号由1~4数字组成</span></td>
				</tr>
				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>姓名</label></td>
					<td align="left"><input type="text" class="form-control"
						name="teacher_name" id="teacher_name" onblur="checkName()"
						value=${teacher.teacher_name}><span id="checktext2">请输入正确的名字</span></td>
				</tr>




				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>性别</label></td>
					<td>
						<!-- 
					<c:choose>
						<c:when test="${teacher.teacher_gendar == 男}">
							<label class="radio-inline"> <input type="radio"
								name="teacher_gendar" value="男" checked="checked"> 男
							</label>
							<label class="radio-inline"> <input type="radio"
								name="teacher_gendar" value="女"> 女
							</label>
						</c:when>
						<c:when test="${eacher.teacher_gendar == 女}">
							<label class="radio-inline"> <input type="radio"
								name="teacher_gendar" value="男"> 男
							</label>
							<label class="radio-inline"> <input type="radio"
								name="teacher_gendar" value="女" checked="checked"> 女
							</label>
						</c:when>
					</c:choose>
					
					--> <label class="radio-inline"> <input type="radio"
							name="teacher_gendar" value="男"
							<c:if test="${teacher.teacher_gendar=='男' }">checked="checked"</c:if> />男
					</label> <label class="radio-inline"> <input type="radio"
							name="teacher_gendar" value="女"
							<c:if test="${teacher.teacher_gendar=='女' }">checked="checked"</c:if> />女
					</label>
					</td>
				</tr>
				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>学位</label></td>
					<td align="left"><input type="text" class="form-control"
						name="teacher_degree" id="teacher_degree" onblur="checkDegree()"
						value=${teacher.teacher_degree}><span id="checktext4">学士、硕士、博士....</span></td>
				</tr>
				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>职称</label></td>
					<td align="left"><input type="text" class="form-control"
						name="teacher_jobtitle" id="teacher_jobtitle"
						onblur="checkJobtitle()" value=${teacher.teacher_jobtitle}><span
						id="checktext5">助教、教授.....</span></td>
				</tr>
				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>年龄</label></td>
					<td align="left"><input type="text" class="form-control"
						name="teacher_age" id="teacher_age" onblur="checkAge()"
						value=${teacher.teacher_age}><span id="checktext6">数字0~120</span></td>
				</tr>
				<tr>
					<td align="right"><sup> <font color="red">*</font>
					</sup> <label>部门</label></td>
					<td><select name="deptno" size="1">
							<c:forEach items="${dept}" var="d">
								<option value="${d.deptno}"
									<c:if test="${teacher.deptno == d.deptno}">selected="selected" </c:if>>${d.dept_name}</option>
							</c:forEach>
					</select> <!-- 
					<select name="deptno" size="1">
							<option value="0"
								<c:if test="${teacher.deptno == 0}">selected="selected" </c:if>>教务处</option>
							<option value="1"
								<c:if test="${teacher.deptno == 1}">selected="selected" </c:if>>机械工程学院</option>
							<option value="2"
								<c:if test="${teacher.deptno == 2}">selected="selected" </c:if>>电气与信息工程学院</option>
							<option value="3"
								<c:if test="${teacher.deptno == 3}">selected="selected" </c:if>>材料科学与工程学院</option>
							<option value="4"
								<c:if test="${teacher.deptno == 4}">selected="selected" </c:if>>汽车工程学院</option>
							<option value="5"
								<c:if test="${teacher.deptno == 5}">selected="selected" </c:if>>经济管理学院</option>
							<option value="6"
								<c:if test="${teacher.deptno == 6}">selected="selected" </c:if>>马克思主义学院</option>
							<option value="9"
								<c:if test="${teacher.deptno == 9}">selected="selected" </c:if>>外国语学院</option>
							<option value="15"
								<c:if test="${teacher.deptno ==15}">selected="selected" </c:if>>理学院</option>
							<option value="16"
								<c:if test="${teacher.deptno == 16}">selected="selected" </c:if>>体育课部</option>
							<option value="18"
								<c:if test="${teacher.deptno == 18}">selected="selected" </c:if>>人武部</option>
							<option value="19"
								<c:if test="${teacher.deptno == 19}">selected="selected" </c:if>>图书馆</option>
							<option value="20"
								<c:if test="${teacher.deptno == 20}">selected="selected" </c:if>>其他</option>
							<option value="21"
								<c:if test="${teacher.deptno == 21}">selected="selected" </c:if>>学工部</option>
							<option value="22"
								<c:if test="${teacher.deptno == 22}">selected="selected" </c:if>>高教研究所</option>
					</select> --></td>
				</tr>
				<tr>
					<td align="center" colspan="2">
						<button type="submit" id="nbutton">确认修改</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>