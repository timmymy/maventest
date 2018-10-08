<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>login</title>
</head>
<body>
<div>
	<form action="login" method="post">
		账号：<input type="text" id="act" name="act" required="required" /><br>
		密码：<input type="password" id="pwd" name="pwd" required="required" /><br>
		<input type="submit" id="submit" value="login" />
		<input type="reset" id="reset" value="reset" />
	</form>
</div>
<input type="hidden" id="msg" value="${msg }">
</body>
<script type="text/javascript">
window.onload=function(){
	var msg = document.getElementById("msg").value;
	 if(msg!=null&&msg!=""){
		alert(msg);			 
	 } 
}
</script>
</html>