package com.magic.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

public class ChatListAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<EmployeesVO> list = EmployeesDAO.getInstance().MemberList();
		request.setAttribute("memberList", list);
		
		request.getRequestDispatcher("chat/chatList.jsp").forward(request, response);
		
	}

}
