<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginSelect.jsp" method="post">
		<label for="id">아이디 : </label>
		<input type="text" name="id" id="id"><br>
		
		<label for="id">암&nbsp;&nbsp; 호 : </label>
		<input type="password" name="pwd" id="pwd"><br>
		
		<input type="radio" name="select" id="user" value="사용자" checked>사용자
		<input type="radio" name="select" id="admin" value="관리자">관리자<br>
		
		<input type="submit" value="로그인">
	</form>
</body>
</html>