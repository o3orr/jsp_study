package com.db.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.db.dao.BoardDao;
import com.db.dto.BoardDto;


@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		
		
		request.getRequestDispatcher("board/update.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("no");
		String name= request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		BoardDto dto = new BoardDto();
		dto.setNo(Integer.parseInt(no));
		dto.setName(name);
		dto.setTitle(title);
		dto.setContent(content);
		dto.setDate(currentDate);
		
		BoardDao dao = BoardDao.getInstance();
		dao.update(dto);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("updatedetail", dto);
		
		request.getRequestDispatcher("board/updateDetail.jsp").forward(request, response);
	}

}
