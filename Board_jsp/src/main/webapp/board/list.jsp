<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="write.do">
		<h1>전체글</h1>
		<table>
			<c:forEach var="list" items="${board}">
			<tr>
				<td>${list.no}</td>
				<td>${list.name}</td>
				<td><a href="detail.do?no=${list.no }">${list.title}</a></td>
				<td>${list.date}</td>		
			</tr>
			
			</c:forEach>
		</table>
		<input type="submit" value="글쓰기">
	</form>
</body>
</html>