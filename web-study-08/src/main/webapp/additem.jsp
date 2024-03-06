<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	Connection con = null;
	PreparedStatement pstmt = null;
	
	String url ="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	String username = "c##ezen";
	String password = "1234";
	String sql = "insert into item values(?, ?, ?)";

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
	String price = request.getParameter("price");
	String description = request.getParameter("description");

	try {
		
		// 1 드라이버 연결
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2. 데이터베이스 연결
		con = DriverManager.getConnection(url, username, password);
		
		// 3. sql 구문 전송
		pstmt = con.prepareStatement(sql);
		
		// 4. insert는 매핑
		pstmt.setString(1, name);
		//pstmt.setString(2, price);
		pstmt.setInt(2, Integer.parseInt(price));
		pstmt.setString(3, description);
		
		// 5. 
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
<h3>상품 등록 성공</h3>
<a href="selectitem.jsp">상품 정보 보기</a>
</body>
</html>