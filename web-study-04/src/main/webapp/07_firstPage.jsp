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
	pageContext.setAttribute("name", "page man");
	request.setAttribute("name", "request man");
	session.setAttribute("name", "session man");
	application.setAttribute("name", "application man");
	
	System.out.println("firstPage.jsp");
	System.out.println("pageContext : " + pageContext.getAttributesScope("name"));
	System.out.println("request : " + request.getAttribute("name"));
	System.out.println("session : " + request.getAttribute("name"));
	System.out.println("application : " + request.getAttribute("name"));
	
	request.getRequestDispatcher("07_secondPage.jsp").forward(request, response);
	
	%>

</body>
</html>