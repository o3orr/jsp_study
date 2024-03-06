<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Connection con = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String username = "c##ezen";
	String password = "1234";
	String sql = "select * from employee";
	ResultSet rs = null;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="800px" border="1">
		
	<%
		
	try{
		
		// 1 드라이브 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		con = DriverManager.getConnection(url, username, password);
		
		// 3 구문 전송
		pstmt = con.prepareStatement(sql);
		
		// 실행결과
		rs = pstmt.executeQuery(sql);
		
		while(rs.next()){
			out.println("<tr>");
			out.println("<td>"+ rs.getString("name") + "</td>");
			out.println("<td>"+ rs.getString("address") + "</td>");
			out.println("<td>"+ rs.getString("ssn") + "</td>");
			out.println("</tr>");	
		}
	} catch(Exception e){
		e.printStackTrace();
	} finally {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	%>
	
	</table>
</body>
</html>