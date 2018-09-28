<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>staff list</title>
<style type="text/css">
table{
	border-collapse: collapse;
	border: 1px solid black;
	margin-top: 50px;
	margin-left: 30%;
	text-align: center;
}
 table td {
	border: 1px solid black;
}
table.tr{
	width: 600px;
	height: 50px;
}
</style>
</head>
<body>
<h1 style="text-align: center;text-shadow: gray;">员工列表</h1>
<h3 style="text-align: right;margin-right: 20%"><a href="addDo">新增员工</a> </h3>
<table style="width: 600px;height: 400px">
			<tr style="background-color:#A7C942;">
				<td>id</td>
				<td>员工姓名</td>
				<td>工号</td>
				<td>组编号</td>
				<td>所在组名</td>
				<td>所在项目组</td>
				<td>操作</td>
			</tr>
	<c:if test="${!empty(list) }">
		<c:forEach items="${list }" var="staffInfo">
			<tr>
				<td style="width: 30px;">${staffInfo.staffId }</td>
				<td style="width: 100px;">${staffInfo.staffName }</td>
				<td style="width: 100px;">${staffInfo.staffJobId }</td>
				<td style="width: 100px;">${staffInfo.team.teamId }</td>
				<td style="width: 100px;">${staffInfo.team.groupName }</td>
				<td style="width: 100px;">${staffInfo.team.projectName }</td>
				<td style="width: 60px"><a href="delete?id=${staffInfo.staffJobId }" style="text-decoration: none;">del</a>
										<a href="editDo?id=${staffInfo.staffJobId }" style="text-decoration: none;">edit</a> 
										</td>
			</tr>
		</c:forEach>
	</c:if>
</table>
<input type="hidden" id="msg" value="${msg }" >
</body>
<script type="text/javascript">
		var msg = document.getElementById("msg").value;
		 console.log(msg);
		 if(msg!=null&&msg!=""){
			alert(msg);			 
		 } 
	
</script>
</html>