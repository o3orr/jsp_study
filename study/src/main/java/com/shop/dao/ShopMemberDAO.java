package com.shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.shop.dto.ShopMemberVo;


// Data Access Object
public class ShopMemberDAO {
	
	private static ShopMemberDAO instance = new ShopMemberDAO();
	private Connection con = null; //연결
	private PreparedStatement pstmt = null; //sql에 담아줌
	private ResultSet rs = null; //결과
	
	private ShopMemberDAO() {
		// 생성자를 사용할 수 없게 함
	}
	
	
	// getInstance -> 이걸 사용해서 객체의 주소를 반환해줘서 객체를 하나만 사용할 수 있게함
	public static ShopMemberDAO getInstance() {
		return instance;
	}
	
	
	// db연결하는 getConnection() 메서드 항상 호출해서 재사용
	public Connection getConnection() throws Exception {
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##study";
		String password = "1234";
		
		// 1. DB드라이브 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. DB 연결
		return DriverManager.getConnection(url, user, password);
	}


	// idCheck.do 페이지에서 DAO를 사용해 아이디 중복체크하기 위한 함수
	public int confirmID(String userid) {
		int result = -1;
		
		// db에서 id입력창에 입력한 값과 똑같은 id가 있는지 찾는 sql구문
		String sql = "select userid from member where userid = ?";
		
		try {
			
			// 1. 연결
			con = getConnection();
			
			// 2. sql문 전송
			pstmt = con.prepareStatement(sql);
			
			// 3. 매핑
			pstmt.setString(1, userid);
			
			// 4. 실행 및 결과 값 받기
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
		
		// 1 or -1리턴
		return result;
	}


	
	// 회원가입 창에 회원입력하면 그대로 테이블에 값넣어주는 메서드
	public int insertMember(ShopMemberVo vo) {
		int result = -1;
		
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		
		try {
			// 1. 연결
			con = getConnection();
			
			// 2. sql구문 전송
			pstmt = con.prepareStatement(sql);
			
			// 3. 매핑
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getPhone());
			pstmt.setInt(6, vo.getAdmin());
			
			// 4. 구문실행
			result = pstmt.executeUpdate(); //성공하면 1이 담김
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	
	
	
	
	

}
