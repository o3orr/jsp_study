package com.magic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConversationsDAO {

	private static ConversationsDAO instance = new ConversationsDAO();
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private ConversationsDAO() {}
	
	public static ConversationsDAO getInstance() {
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
	
	//member id 두개를 이용해 대화 id를 가져오는 메서드
	public int getConversationIdByUsers(String userId1, String userId2) {
	    int convNum = -1;
	    
	    String sql = "SELECT conversation_id " +
	                 "FROM conversations " +
	                 "WHERE (participant1_id = ? AND participant2_id = ?) " +
	                 "   OR (participant1_id = ? AND participant2_id = ?)";

	    try {
	        con = getConnection();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, userId1);
	        pstmt.setString(2, userId2);
	        pstmt.setString(3, userId2);
	        pstmt.setString(4, userId1);
	        
	        rs = pstmt.executeQuery();
	        
	        if (rs.next()) {
	            convNum = rs.getInt("conversation_id");
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(con, pstmt, rs);
	    }
	    
	    return convNum;
	}

	
	
	
}
