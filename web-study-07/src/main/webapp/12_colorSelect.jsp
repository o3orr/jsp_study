<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${param.color==1 }">
	<h1>빨강</h1>
</c:if>

<c:if test="${param.color==2 }">
	<h1>파랑<h1>
</c:if>

<c:if test="${param.color==2 }">
	<h1>노랑<h1>
</c:if>

</body>
</html>