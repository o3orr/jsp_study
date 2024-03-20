package com.shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shop.vo.ProductVO;
import com.shop.vo.ReviewVO;


public class ReviewDAO {
private static ReviewDAO instance = new ReviewDAO();

private Connection con = null;
private PreparedStatement pstmt = null;
private ResultSet rs = null;
	
	private ReviewDAO() {}

	public static ReviewDAO getInstance() {
		return instance;
	}
	
	private Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "c##ezen";
		String password = "1234";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url, user, password);
	}
	
	private void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void close(Connection con, Statement stmt) {
		try {
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ReviewVO> selectReviewByProduct(int product_id) {
		String sql = "select * from Review where product_id = ?";

		
		List<ReviewVO> list  = new ArrayList();
	
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product_id);
			rs = pstmt.executeQuery();
					
			
			if(rs.next()) {
				ReviewVO vo  = new ReviewVO();
				vo.setReview_id(rs.getInt("review_id"));
				vo.setUser_id(rs.getInt("user_id"));
				vo.setProduct_id(rs.getInt("product_id"));
				vo.setRating(rs.getInt("rating"));
				vo.setCommands(rs.getString("commands"));
				vo.setCreated_at(rs.getDate("created_at"));
				
				list.add(vo);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return list;
	}
	
}
