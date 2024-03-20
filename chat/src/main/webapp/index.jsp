<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty loginUser}">
			<input type="button" value="로그인" onclick="location.href='ChatServlet?command=login_form'">
		</c:when>
		<c:otherwise>
			<input type="button" value="채팅" onclick="location.href='ChatServlet?command=chat_list'">
		</c:otherwise>
	</c:choose>
	
</body>
</html>