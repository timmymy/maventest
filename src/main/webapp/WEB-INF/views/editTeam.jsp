<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>edit staffInfo in here</title>
<style type="text/css">
#body {
	width: 400px;
	height: 500px;
	margin-left: 40%;
}
</style>
</head>
<body>
	<div style="float: right; margin-right: 10%;">
		<span style="font-size: 20px; color: green;">${staffInfo.staffName }&nbsp;&nbsp;&nbsp;&nbsp;${staffInfo.team.projectName }</span>
		<a href="../staff/logout">退出</a>
	</div>
	<div id="body">
		<form action="edit" method="post">
			小组编号：<input type="text" id="teamId" name="teamId"
				value="${teamInfo.teamId }" readonly="readonly" /><br>
			小组名：<input type="text" id="groupName" name="groupName"
				value="${teamInfo.groupName }" /> <br> 
			项目组名：<input type="text" id="projectName" name="projectName"
				value="${teamInfo.projectName }" /> <br> 
				<input type="submit"
				id="submit" value="提交">&nbsp;&nbsp;&nbsp; <input
				type="reset" id="reset" value="重置">
		</form>
	</div>
</body>
</html>