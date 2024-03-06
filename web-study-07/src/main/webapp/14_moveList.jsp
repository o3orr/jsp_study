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
<%
	String[] movieList = {"타이타닉", "시네마 천국", "혹성 탈출", "킹콩"};
	pageContext.setAttribute("movieList2", movieList);
	
%>		

<table border="1" style="width: 100%; text-aling: center">
	<tr>
		<th>index</th>
		<th>count</th>
		<th>title</th>
	</tr>
	
	<c:forEach items="${movieList2}" var="movie" varStatus="status">
	<tr>
		<td>${status.index}</td> <!-- status는 자동생성 -->
		<td>${status.count}</td>
		<td>${movie}</td>
	</tr>
	</c:forEach>
</table>

	<ul>
	<c:forEach var="movie" items="${movieList2 }" varStatus="status">
		<c:choose>
			<c:when test="${status.first }">
				<li styel="font-weight: bold; color: red;">${movie}</li>
			</c:when>
			<c:otherwise>
				<li>${movie}</li>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	</ul>
	
	<c:forEach var="movie" items="${movieList}" varStatus="status">
		${movie } <c:if test="${not status.last }">, </c:if>
	</c:forEach>
</body>
</html>