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


@WebServlet("/mypage.do")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	//마이페이지에 get방식으로 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//마이페이지에 get방식으로 요청보내기 전에 회원정보띄우기위해 
		//get방식으로 들어온 파라미터를 활용해 세션에다가 정보담아줌 
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		EmployeesVO vo = eDao.getMember(id);
		
		HttpSession session = request.getSession();
		
		if(vo != null) {
			session.setAttribute("mVo", vo); //mVo는 vo가 들어있는 세션을 다른 곳에서 호출할 때 사용한는 이름
		}	
		
		request.getRequestDispatcher("member/mypage.jsp").forward(request, response);
	}


	// 마이페이지에 post방식으로 요청 -> mypage.jsp폼에서 회원정보 수정 -> 그다음 정보만띄워주는 jsp페이지로 포워드
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
		int result = eDao.updateMember(vo); // 테이블에 넣어주는 memberDAO의 메서드
		
		// 세션 가져오기
		HttpSession session = request.getSession();
		session.setAttribute("mVo", vo); //mypage2에 띄워줄 정보 세션에담아서 보내줌
		response.sendRedirect("mypage2.do");
	}

}
