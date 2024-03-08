package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.tag.common.fmt.RequestEncodingSupport;

import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;


@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("member/join.jsp");
		dis.forward(request, response);
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
		int result = mDao.insertMember(vo); // 테이블에 넣어주는 memberDAO의 메서드
		
		// 세션 가져오기
		HttpSession session = request.getSession();
		
		if(result == 1) {
			// 회원 가입 성공
			// 성공하면 로그인화면에 세션 이용해서 자동으로 아이디 띄워줌
			session.setAttribute("userid", userid); 
			request.setAttribute("message", "회원가입에 성공했습니다");
			
		} else {
			// 회원 가입 실패
			request.setAttribute("message", "회원가입에 실패했습니다");
		}
		
		// 회원가입을 실행하고 로그인 화면으로 돌아감
		// 성공하면 로그인화면에 성공했습니다 뜨고 실패하면 로그인화면 밑에 실패했습니다 뜸
		request.getRequestDispatcher("member/login.jsp")
			.forward(request, response);
	}

}
