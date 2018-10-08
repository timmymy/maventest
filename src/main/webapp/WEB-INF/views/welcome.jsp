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
<span style="font-size: 20px;color: green;">${staff.staffName }&nbsp;&nbsp;&nbsp;&nbsp;${staff.team.projectName }</span>
</div>
<h1><a href="show">查看所有员工信息</a></h1>
<input type="hidden" id="msg" value="${msg }">
</body>
<script type="text/javascript">
var msg = document.getElementById("msg").value;
console.log(msg);
if(msg!=null&&msg!=""){
	alert(msg);			 
} 

</script>
</html>