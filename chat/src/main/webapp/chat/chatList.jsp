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
	<c:forEach items="${memberList}" var="member">
    	<span onclick="location.href='ChatServlet?command=chat_room&receiver_id=${member.id}&loginUser_id=${loginUser.id }'">
    		${member.name}(${member.id})<br>
    	</span><hr>
	</c:forEach>
</body>
</html>