<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>error</title>
</head>
<body>
<h1><font style="color: red;font-size: xx-large;">${msg }</font></h1>
</body>
<script type="text/javascript">
var i=5;
var intervalid;
intervalid = setInterval("fun()",1000);
function fun() {
	if (i == 0) {
		javascript:history.go(-1);
		clearInterval(intervalid);
	}
}
</script>
</html> 