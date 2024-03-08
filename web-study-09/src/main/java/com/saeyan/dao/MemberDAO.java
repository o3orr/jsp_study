package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.saeyan.dto.MemberVO;

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

	
	
	public int insertMember(MemberVO vo) {
		int result = -1;
		
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		
		try {
			// 1.연결
			con = getConnection();
			// 2. sql 구문 전송
			pstmt = con.prepareStatement(sql);
			// 3. 매핑
			// vo에 값을 담아서 db에 전송
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
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}

	
	// 로그인할때 db에 유저있는지 없는지 확인하는 메서드
	public int userCheck(String userid, String pwd) {
		int result = -1;
		
		String sql = "select pwd from member where userid = ? ";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery(); 
			//값이 안나왔으면 비밀번호가 틀렸다는 뜻
			
			if(rs.next()) {
				if(rs.getString("pwd").equals(pwd)) {
					// 비밀번호로 찾은 아이디 값이 있고 비밀번호가 맞음 아이디/비밀번호 일치 
					result = 1; //로그인 성공
				} else {
					// 비밀번호로 찾은 아이디 값이 있고 비밀번호가 틀림 -> 비밀번호 불일치 
					result = -1; 
				}
			} else {
				//값이 없으면 비밀번호로 아이디 찾는게 안됐다는 뜻이니까 그런 아이디없음
				result = 0;
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

	
	// 테이블에서 한명의 회원의 모든 정보 가져오는 메서드
	public MemberVO getMember(String userid) {
		String sql = "select * from member where userid = ?";
		MemberVO vo =  new MemberVO(); //값을 전체로 넘겨줄 객체
		
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setUserid(rs.getString("userid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setEmail(rs.getString("email"));
				vo.setPhone(rs.getString("phone"));
				vo.setAdmin(rs.getInt("admin"));
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
		return vo;
	}

	
	// 회원정보 수정해주는 메서드
	public int updateMember(MemberVO vo) {
		
		int result = -1;
		
		String sql = "update member set name=?, pwd=?, email=?, "
				+ "phone=?, admin = ? where userid = ?";
		
		try {
			// 1.연결
			con = getConnection();
			// 2. sql 구문 전송
			pstmt = con.prepareStatement(sql);
			// 3. 매핑
			// vo에 값을 담아서 db에 전송
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getPhone());
			pstmt.setInt(5, vo.getAdmin());
			pstmt.setString(6, vo.getUserid());
			
			// 4. 구문실행
			result = pstmt.executeUpdate(); //성공하면 1이 담김
			
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
