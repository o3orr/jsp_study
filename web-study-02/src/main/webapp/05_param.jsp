<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="param.js"></script>
</head>
<body>
	<form name="frm" action="ParamServlet" method="post">
		아이디 : <input type="text" name="id" value="free"><br>
		나&nbsp;&nbsp;이 : <input type="password" name="pass" value="1234"><br>
		
		<input type="submit" value="로그인" onclick="return check();">
	
	</form>
</body>
</html>