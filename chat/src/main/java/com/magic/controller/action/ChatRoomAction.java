package com.magic.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.magic.dao.ConversationsDAO;
import com.magic.dao.MessagesDAO;
import com.magic.dto.MessagesVO;

public class ChatRoomAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	response.setContentType("text/html;charset=UTF-8");
    	
        String receiverId = request.getParameter("receiver_id");
        String loginUserId = request.getParameter("loginUser_id");
        
        int convId = ConversationsDAO.getInstance().getConversationIdByUsers(loginUserId, receiverId);
        

        List<MessagesVO> messagesList = MessagesDAO.getInstance().getMessagesByConversationId(convId);
        

        request.setAttribute("messagesList", messagesList);
        
        request.getRequestDispatcher("/chat/chatRoom.jsp").forward(request, response);
        
        
        
    }
  
}
