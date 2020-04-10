var nameReg = /^[\u2E80-\u9FFF]+$/;
var degreeReg = /^学士$|^硕士$|^博士^/;
var ageReg = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
var flag = false;

function checkName() {
	var name = document.getElementById("teacher_name").value;

	if (name.length > 10) {
		$("#checktext2").css("color", "red").html("x输入超限!");
		return false;
	}
	if (!nameReg.test(name)) {
		$("#checktext2").css("color", "red").html("x 输入不合法!");
		return false;
	} else {
		$("#checktext2").css("color", "green").html("√ 输入合法!")
		return true;
	}
}

function checkDegree() {
	var degree = document.getElementById("teacher_degree").value;
	if (!degreeReg.test(degree)) {
		$("#checktext4").css("color", "red").html("x 输入不合法!");
		return false;
	} else {
		$("#checktext4").css("color", "green").html("√ 输入合法!")
		return true;
	}
}

function checkAge() {
	var age = document.getElementById("teacher_age").value;
	if (!ageReg.test(age)) {
		$("#checktext6").css("color", "red").html("x 输入不合法!");
		return false;
	} else {
		$("#checktext6").css("color", "green").html("√ 输入合法!")
		return true;
	}
}

function validateForm() {
	if (checkName() && checkDegree() && checkAge()) {
		alert('修改成功，点击确定，跳转到教师信息页面！');
		return true;
	} else {
		alert('你的输入有误，请按要求输入后再提交');
		return false;
	}
}