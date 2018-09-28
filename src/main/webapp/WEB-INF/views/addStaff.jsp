<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>add new staffInfo </title>
<style type="text/css">
 #body{
 	width: 400px;
 	height: 500px;
 	margin-left: 40%;
 }
</style>
</head>
<body>
<div id="body">
	<form action="add" method="post">
		员工姓名：<input type="text" id="staffName" name="staffName" /><br>
		员工密码：<input type="password" id="staffPwd" name="staffPwd" /> <br>
		员工工号：<input type="text" id="staffJobId" name="staffJobId" /><br>
		所在组编号：<input type="text" id="teamId" name="teamId" /> <br>
		<input type="submit" id="submit" value="提交">&nbsp;&nbsp;&nbsp;
		<input type="reset" id="reset" value="重置">
	</form>
</div>
</body>
</html>