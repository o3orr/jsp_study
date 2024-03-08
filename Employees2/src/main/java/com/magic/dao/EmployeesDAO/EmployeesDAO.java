package com.magic.dao.EmployeesDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.magic.dto.EmployeesVO.EmployeesVO;




public class EmployeesDAO {
	
	private static EmployeesDAO instance = new EmployeesDAO();
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private EmployeesDAO() {
		
	}
	
	public static EmployeesDAO getInstance() {
		return instance;
	}
	
	
	// db연결할때 사용하는 메서드
	public Connection getConnection() throws Exception {
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##ezen";
		String password = "1234";
		
		// 1. DB 드라이브 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 2. DB 연결
		return DriverManager.getConnection(url, user, password);
	}

	
	
	// 로그인할때 db에 유저있는지 없는지 확인하는 메서드
		public int userCheck(String id, String pass) {
			int result = -1;
			
			String sql = "select pass from Employees where id = ? ";
			
			try {
				con = getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				
				rs = pstmt.executeQuery(); 
				//값이 안나왔으면 비밀번호가 틀렸다는 뜻
				
				if(rs.next()) {
					if(rs.getString("pass").equals(pass)) {
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
	
		
		
	// 테이블에서 한명의 회원 모든 정보 가져오는 메서드
	public EmployeesVO getMember(String id) {
		String sql = "select * from Employees where id = ?";
		EmployeesVO vo = new EmployeesVO(); //값을 넘겨줄 객체
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setPass(rs.getString("pass"));
				vo.setName(rs.getString("name"));
				vo.setLev(rs.getString("lev"));
				vo.setEnter(rs.getDate("enter"));
				vo.setGender(rs.getString("gender")); // 수정: getInt에서 getString으로 변경
				vo.setPhone(rs.getString("phone"));
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

	
	// 테이블에 정보넣어주는 메서드
	public int insertMember(EmployeesVO vo) {
		int result = -1;
		
		String sql = "insert into Employees values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			// 1.연결
			con = getConnection();
			// 2. sql 구문 전송
			pstmt = con.prepareStatement(sql);
			// 3. 매핑
			// vo에 값을 담아서 db에 전송
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getLev());
			pstmt.setDate(5, vo.getEnter());
			pstmt.setString(6, vo.getGender());
			pstmt.setString(7, vo.getPhone());
			
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
	
	// 회원정보 수정해주는 메서드
		public int updateMember(EmployeesVO vo) {
			
			int result = -1;
			
			String sql = "update employees set pass=?, name=?, lev=?, "
					+ "enter=?, gender = ?, phone = ? where id = ?";
			
			try {
				// 1.연결
				con = getConnection();
				// 2. sql 구문 전송
				pstmt = con.prepareStatement(sql);
				// 3. 매핑
				// vo에 값을 담아서 db에 전송
				pstmt.setString(1, vo.getPass());
				pstmt.setString(2, vo.getName());
				pstmt.setString(3, vo.getLev());
				pstmt.setDate(4, vo.getEnter());
				pstmt.setString(5, vo.getGender());
				pstmt.setString(6, vo.getPhone());
				pstmt.setString(7, vo.getId());
				
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
