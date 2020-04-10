<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" type="text/css" href="css/css.css">
<!-- <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"> -->
</head>
<body style="padding-top: 20px;">
	<div class="container">
		<div class="col-md-12 col-md-offset-2">
			<h1 align=center>用户登录</h1>
			<form action="login" method="post">
				<div class="form-group">
					<label>教师编号</label> <input type="text" class="form-control"
						name="teacher_id">
				</div>
				<div class="form-group">
					<label>教师姓名</label> <input type="text" class="form-control"
						name="teacher_name">
				</div>
				</br>
				<button type="submit" class="btn btn-info btn-sm">登录</button>
			</form>
		</div>
	</div>
</body>
</html>