<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${param.id}님

<c:choose>
	<c:when test="${param.select == '사용자' }">사용자로</c:when>
	<c:otherwise>관리자로</c:otherwise>
</c:choose>
로그인하셨습니다
</body>
</html>