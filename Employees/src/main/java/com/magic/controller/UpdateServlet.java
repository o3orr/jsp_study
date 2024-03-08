package com.magic.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.magic.dao.EmployeesDAO.EmployeesDAO;
import com.magic.dto.EmployeesVO.EmployeesVO;


@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("member/update.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String lev = request.getParameter("lev");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		
		EmployeesVO vo = new EmployeesVO();
		vo.setId(id);
		vo.setPass(pass);
		vo.setName(name);
		vo.setLev(lev);
		vo.setEnter(currentDate);
		vo.setGender(gender);
		vo.setPhone(phone);
		
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		int result = eDao.insertMember(vo);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("mVo", vo);
		
		request.getRequestDispatcher("member/update2.jsp")
		.forward(request, response);
	}

}
