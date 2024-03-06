package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 싱글톤으로 사용
// 데이터베이스 연결하는 중복코드 제거하려고 사용
// data access object
public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private MemberDAO() {
		
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	// db 연결하는 메서드
	public Connection getConnection() throws Exception {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##ezen";
		String password = "1234";
		
		// 1. DB 드라이브 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. DB 연결
		return DriverManager.getConnection(url, user, password);
	}
	
	// ID 중복 체크 메서드
	public int confirmID(String userid) {
		int result = -1;
		
		String sql = "select userid from member where userid = ?";
		
		try {
			// 1. 연결
			con = getConnection();		
			
			// 2. sql문 전송
			pstmt = con.prepareStatement(sql);
			
			// 3. 매핑
			pstmt.setString(1, userid); 
			// 아이디 중복 체크를 위한 아이디를 넣으면 데이터베이스에서 
			// 이렇게 생긴 아이디가 있는지 찾음
			
			// 4. 실행 및 결과값 받기
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1; //중복이면 1
			} else {
				result = -1; //중복이 아니면 -1
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
