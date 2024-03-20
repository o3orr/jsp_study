package com.magic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.magic.dto.MessagesVO;

public class MessagesDAO {

	private static MessagesDAO instance = new MessagesDAO();
	
	
	private MessagesDAO() {}
	
	public static MessagesDAO getInstance() {
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
	
	public List<MessagesVO> getMessagesByConversationId(int conversationId) {
	    List<MessagesVO> list = new ArrayList<>();
	    Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

	    String sql = "SELECT * FROM messages WHERE CONVERSATION_ID = ?";

	    try {
	        con = getConnection();
	        pstmt = con.prepareStatement(sql);
	        pstmt.setInt(1, conversationId);
	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            MessagesVO vo = new MessagesVO();
	            vo.setMessage_id(rs.getInt("message_id"));
	            vo.setConversation_id(rs.getInt("conversation_id"));
	            vo.setSender_id(rs.getString("sender_id"));
	            vo.setReceiver_id(rs.getString("receiver_id"));
	            vo.setMessage_content(rs.getString("message_content"));
	            vo.setCreation_date(rs.getDate("creation_date"));

	            list.add(vo);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        close(con, pstmt, rs);
	    }

	    return list;
	}

	
	
	
}
