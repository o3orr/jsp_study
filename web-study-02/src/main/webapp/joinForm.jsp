<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="joinServlet" method="post">
		<label for="name">이름</label>
		<input type="text" name="name" id="name"><br>
		
		<label for="jumin1">주민등록번호</label>
		<input type="text" name="jumin1" id="jumin1">-
		<input type="password" name="jumin2" id="jumin2"><br>
		
		<label for="name">아이디</label>
		<input type="text" name="id" id="id"><br>
		
		<label for="pwd">비밀번호</label>
		<input type="text" name="id" id="id"><br>
	</form>
</body>
</html>