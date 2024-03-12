package com.db.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.db.dao.BoardDao;
import com.db.dto.BoardDto;


@WebServlet("/write.do")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("board/write.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("no");
		String name = request.getParameter("name");
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
		int result = dao.insert(dto);
		
//		if(result == 1) {
//			request.setAttribute("message", "글쓰기에 성공했습니다");
//		}
		
		request.getRequestDispatcher("board/list.jsp")
			.forward(request, response);
	}

}
