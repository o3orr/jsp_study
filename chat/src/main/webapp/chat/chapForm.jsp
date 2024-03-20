<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="chatAction" method="post">
		<input type="hidden" name="command" value="chat_action">
		${loginUser.name }
		<textarea rows="10" cols="5"></textarea>
	</form>
</body>
</html>


