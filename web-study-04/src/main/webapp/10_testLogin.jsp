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

	String name = "윤지수";
	String id = "asdf";
	String pwd = "1234";
	
	if(id.equals(request.getParameter("id")) 
		&& pwd.equals(request.getParameter("pwd"))){
		session.setAttribute("loginUser", name); // 세션 발급
		response.sendRedirect("10_main.jsp");
	} else {
		response.sendRedirect("10_loginForm.jsp");
	}
		

%>
</body>
</html>