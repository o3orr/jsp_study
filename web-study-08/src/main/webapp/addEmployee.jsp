<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	Connection con = null;
	PreparedStatement pstmt = null;
	
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String username = "c##ezen";
	String password = "1234";
	String sql = "insert into EMPLOYEE values(?, ?, ?)";

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String ssn = request.getParameter("ssn");

	try{
		// 1. 드라이브 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. 데이터베이스 연결
		con = DriverManager.getConnection(url, username, password);
		
		// 3. sql 문장 전송
		pstmt = con.prepareStatement(sql);
		
		// 4. 매핑
		pstmt.setString(1, name);
		pstmt.setString(2, address);
		pstmt.setString(3, ssn);
		
		// 5. sql 구문 실행
		pstmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		try{
			//자원반납
			if(pstmt != null) pstmt.close();
			if(con != null) con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

%>
<h1>회원 가입 성공</h1>
<a href="selectEmployee.jsp">전체 회원 목록 보기</a>
</body>
</html>