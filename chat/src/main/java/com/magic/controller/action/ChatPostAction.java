package com.magic.controller.action;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.MessagesDAO;
import com.magic.dto.MessagesVO;

public class ChatPostAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	int conversation_id = Integer.parseInt(request.getParameter("conversation_id"));

        HttpSession session = request.getSession();
        
        List<MessagesVO> messagesList = MessagesDAO.getInstance().getMessagesByConversationId(conversation_id);
        
        //메세지 저장하기..
        MessagesVO vo = new MessagesVO();
        
        vo.setConversation_id(Integer.parseInt(request.getParameter("conversation_id")));
        vo.setSender_id(request.getParameter("sender_id"));
        vo.setReceiver_id(request.getParameter("receiver_id"));
        vo.setMessage_content(request.getParameter("message_content"));
        vo.setCreation_date(Date.valueOf(request.getParameter("creation_date")));
        
        MessagesDAO.getInstance().insertMessage(vo);
       
        response.sendRedirect("ChatServlet?command=chat_room&receiver_id=" +vo.getReceiver_id() + "&loginUser_id=" + vo.getSender_id());
        
        
        
        
    }
}
