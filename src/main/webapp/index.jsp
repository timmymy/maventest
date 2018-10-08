<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>staff list</title>
</head>
<body>
<h1>index</h1>
<h2>welcome to linkage</h2>
<h3><a href="staff/show">查看所有员工信息</a></h3>
<form action="staff/search">
	查看指定员工信息:<input type="text" id="searchId" name="searchId" /> &nbsp;&nbsp;&nbsp; <input type="submit" id="submit" name="submit" value="search" />
</form>
<h3><a href="staff/loginDo">login</a></h3>
<h3><a href="staff/registerDo">register</a></h3>
</body>
</html>
