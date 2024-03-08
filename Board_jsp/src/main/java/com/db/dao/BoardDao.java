package com.db.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.dto.BoardDto;





public class BoardDao {
	
	private static BoardDao instance = new BoardDao();
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private BoardDao() {
		
	}
	
	public static BoardDao getInstance() {
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
		
		
	
	// 게시글 전체 출력해서 목록으로 보여주는 메서드
	public List<BoardDto> selectAll() { 
		
		//게시글 목록을 담을 List생성
		List<BoardDto> boardList = new ArrayList<>();
		
		String sql = "select * from board";
		
		try {
			con = getConnection();	
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 결과를 반복문을 통해 읽어옴
			// 결과값이 있다면 계속 반복
			while(rs.next()) {
				BoardDto Dto = new BoardDto();
				Dto.setNo(rs.getInt("no"));
				Dto.setName(rs.getString("name"));
				Dto.setTitle(rs.getString("title"));
				Dto.setContent(rs.getString("content"));
				Dto.setDate(rs.getDate("day"));
				
				boardList.add(Dto);
				
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
		
		return boardList; // 완성된 게시글 목록을 반환
	}
	
	
	
	// 게시글 선택 출력
	public BoardDto selectOne(int no) {
		String sql = "select * from board where no = ?";
		
		BoardDto Dto = new BoardDto(); // 한 게시글만 담을 dto객체 생성
		
		try {
			con = getConnection();    
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, no);
	        rs = pstmt.executeQuery();
	        
	        if(rs.next()) {
	        	//객체에 db에 있는 값 담아서 저장
	        	Dto.setNo(rs.getInt("no"));
	        	Dto.setName(rs.getString("name"));
	        	Dto.setTitle(rs.getString("title"));
	        	Dto.setContent(rs.getString("content"));
	        	Dto.setDate(rs.getDate("day"));       	
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
		
		return Dto;
	}
	
	
	//글 추가
	// 글쓰기 폼에서 dto가 들어옴 그래서 매개변수가 dto
	public int insert(BoardDto dto) {
		int result = -1;
		
		String sql = "insert into board values(?, ?, ?, ?, ?)";
		
		try {
			
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, dto.getNo());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getTitle());
			pstmt.setString(4, dto.getContent());
			pstmt.setDate(5, dto.getDate());
			
			result = pstmt.executeUpdate(); // 성공하면 1이 담김
			
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
	
	
	//글 수정 메서드
	// 글쓰기 폼에서 수정을 누르면 dto가 메서드안으로 들어와서 db에 들어감
	public int update(BoardDto dto) {
			
		int result = -1;
		
		String sql = "update board set name=?, title=?,content=?, "
				+ "date=? where no = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setDate(4, dto.getDate());
			pstmt.setInt(5, dto.getNo());
			
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
	
	
	// 글 삭제 메서드
	public int delete(int no) {
		int result = -1;
		
		String sql = "delete from board where no = ?";
		
		try {
			
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no); //찾아서 삭제
			
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
