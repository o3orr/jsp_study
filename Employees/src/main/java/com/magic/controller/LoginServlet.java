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




@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("member/login.jsp")
			.forward(request, response);
	}


	// 로그인 화면에 post로 요청하면 호출되는 메서드
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String userid = request.getParameter("id");
			String pwd = request.getParameter("pass");
			
			//아이디 패스워드 받고 DB에서 이런 회원이 있나없나 확인
			// 있으면 로그인 성공, 없으면 실패
			
			EmployeesDAO eDao = EmployeesDAO.getInstance();
			
			String url = "member/login.jsp";
			
			// -1 : 비밀번호 틀림 - 0 : 아이디틀림 , 
			// 1 : 로그인 성공
			int result = eDao.userCheck(userid, pwd); //이런 사람 있는지 확인해서 result에 저장
			HttpSession session = request.getSession();
			EmployeesVO vo = eDao.getMember(userid); //userid의 정보전체가 vo에 담겨있음
			
			if(result == 1) {
				//로그인하면 세션에 이름, 아이디 담아서 메인페이지에서 띄울 수 있게 
				
				session.setAttribute("loginUser", vo); //세션 전체에 회원정보객체를 담음
				request.setAttribute("message", "로그인 성공");

				url = "member/loginpage.jsp";
			} else if(result == 0) {
				request.setAttribute("message", "존재하지 않는 회원입니다");
			} else {
				request.setAttribute("message", "비밀번호가 틀렸습니다");
			}
			
			// url로 접속
			request.getRequestDispatcher(url).forward(request, response);
		}

	}
