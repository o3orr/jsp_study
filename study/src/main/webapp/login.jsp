<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
	<form action="JoinServlet.java" method="post">
		<label for="id">아이디</label>
		<input type="text" name="id" id="id"><br>
		
		<label for="pwd">암&nbsp;&nbsp; 호</label>
		<input type="text" name="pwd" id="pwd"><br>
		
		<input type="submit" value="로그인">
		<input type="reset" value="취소">
		
		<input type="button" value="회원가입" onclick="location.href='join.jsp'">
		
	</form>		
	
</body>
</html>