package com.magic.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO;
import com.magic.dto.EmployeesVO;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		EmployeesVO vo = EmployeesDAO.getInstance().getMember(id);
		EmployeesDAO.getInstance().userCheck(id, pwd);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("loginUser", vo);
		
		response.sendRedirect("/chat/");
		
	}

}
