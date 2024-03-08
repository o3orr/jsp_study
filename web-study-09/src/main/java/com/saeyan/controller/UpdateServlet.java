package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;


@WebServlet("/memberUpdate.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");

		MemberDAO mDao = MemberDAO.getInstance();
		
		MemberVO vo = mDao.getMember(userid);
		
		HttpSession session = request.getSession();
		
		if(vo != null) {
			session.setAttribute("mVo", vo); //mVo는 vo가 들어있는 세션을 다른 곳에서 호출할 때 사용한는 이름
		}
		
		request.getRequestDispatcher("member/memberUpdate.jsp")
				.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		MemberVO vo = new MemberVO(); // 값을 실어서 전송해주는 객체
		vo.setName(name);
		vo.setUserid(userid);
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setAdmin(Integer.parseInt(admin));
		
		MemberDAO mDao = MemberDAO.getInstance(); //싱글톤 객체 생성
		int result = mDao.updateMember(vo);
		
		HttpSession session = request.getSession();
		session.setAttribute("message", "회원 정보 수정완료");
		
		response.sendRedirect("member/login.jsp");
		
	}

}
