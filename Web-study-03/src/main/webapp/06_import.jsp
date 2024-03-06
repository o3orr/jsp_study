<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Calendar date = Calendar.getInstance();

	SimpleDateFormat today = new SimpleDateFormat("yyy년 MM월 dd일");
	SimpleDateFormat now = new SimpleDateFormat("yyy년 MM월 dd일");
	
%>
	날짜 시간 <b><%= date.getTime() %></b><br>
</body>
</html>