<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="800" border="1">
	<tr>
		<th>이름</th>
		<th>아이디</th>
		<th>암호</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>권한</th>
	</tr>
	
	<%
	
		// 자바 sql 써줘야함 임포트는
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Connection con = null; //연결된 정보 가지고 있음
		Statement stmt = null;
		ResultSet rs = null; //select 결과 가져옴
		String sql = "select * from member";
		
		try {
			// 1.드라이브 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 데이터베이스 연결
			con = DriverManager.getConnection(url, "c##ezen", "1234");
			// 오라클 연결 주소값, ezen, 1234
			
			// 3. sql 구문 전송 및 실행 결과 rs참조
			stmt = con.createStatement(); //전송
			rs = stmt.executeQuery(sql); // 실행결과
			out.println(rs);
			
			// 4. 데이터베이스 값 출력
			while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+ rs.getString("name") + "</td>");
				out.println("<td>"+ rs.getString("userid") + "</td>");
				out.println("<td>"+ rs.getString("pwd") + "</td>");
				out.println("<td>"+ rs.getString("email") + "</td>");
				out.println("<td>"+ rs.getString("phone") + "</td>");
				out.println("<td>"+ rs.getInt("admin") + "</td>");
				out.println("</tr>");
			} 
			/* while(rs.next()) {
				out.println("<tr>");
				out.println("<td>"+ rs.getString(1) + "</td>");
				out.println("<td>"+ rs.getString(2) + "</td>");
				out.println("<td>"+ rs.getString(3) + "</td>");
				out.println("<td>"+ rs.getString(4) + "</td>");
				out.println("<td>"+ rs.getString(5) + "</td>");
				out.println("<td>"+ rs.getInt(6) + "</td>");
				out.println("</tr>");
			} */
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (con != null) con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	%>
</table>
</body>
</html>