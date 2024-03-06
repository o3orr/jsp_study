<%@page import="java.sql.Connection"%>
<%@page import="com.saeyan.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//db 연결하는 코드
	MemberDAO memDao = MemberDAO.getInstance();
	
	Connection con = memDao.getConnection();
	
	out.println("db 연결 성공 : " + con);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>