package com.shop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.shop.vo.ProductVO;


public class ProductDAO {
private static ProductDAO instance = new ProductDAO();

private Connection con = null;
private PreparedStatement pstmt = null;
private ResultSet rs = null;
	
	private ProductDAO() {}

	public static ProductDAO getInstance() {
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
	
	public ProductVO selectProductByCode(int product_id) {
		String sql = "select * from product where product_id = ?";

		
		ProductVO vo = new ProductVO();
	
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, product_id);
			rs = pstmt.executeQuery();
					
			
			if(rs.next()) {
				vo.setProduct_id(rs.getInt("product_id"));
				vo.setProduct_name(rs.getString("product_name"));
				vo.setCategory(rs.getString("category"));
				vo.setPrice(rs.getInt("price"));
				vo.setStock_quantity(rs.getInt("stock_quantity"));
				vo.setDescription(rs.getString("description"));
				vo.setCreated_date(rs.getDate("created_date"));
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt, rs);
		}
		return vo;
	}
	
}
