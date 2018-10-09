<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>welcome to linkage</title>
</head>
<body>
	<div style="float: right; margin-right: 10%;">
		<input type="hidden" id="logMsg" name="logMsg"
			value="${staffInfo.staffJobId }" /> <span
			style="font-size: 20px; color: green;">${staffInfo.staffName }&nbsp;&nbsp;&nbsp;&nbsp;${staffInfo.team.projectName }</span>
	</div>
	<div
		style="float: right; width: 200px; height: 50px; margin-right: 10%;">
		<div id="isLog" style="display: block; float: left;">
			<a href="loginDo">登录</a> <a href="registerDo">注册</a>
		</div>
		<div id="logout" style="display: none; float: right;">
			<a href="logout">退出</a>
		</div>
	</div>
	<h1>index</h1>
	<h2>welcome to linkage</h2>
	<h3>
		<a href="show" onclick=" return isLog();">查看所有员工信息</a>
	</h3>
	<form action="search">
		查看指定员工信息:<input type="text" id="searchId" name="searchId" />
		&nbsp;&nbsp;&nbsp; <input type="submit" id="submit" name="submit"
			value="search" onclick="return isLog();"/>
	</form>
	<input type="hidden" id="msg" value="${msg }">
</body>
<script type="text/javascript">
	var msg = document.getElementById("msg").value;
	if (msg != null && msg != "") {
		alert(msg);
	}
	var logMsg = document.getElementById("logMsg").value;
	if (logMsg != null && logMsg != "") {
		document.getElementById("isLog").style.display="none";
		document.getElementById("logout").style.display="block";
	}
	function isLog() {
		if (logMsg == null || logMsg == "") {
			alert("login first!");
			return false;
		}else {
			return true;
		}
	}
</script>
</html>