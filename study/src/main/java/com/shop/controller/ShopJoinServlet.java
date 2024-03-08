package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.ShopMemberDAO;
import com.shop.dto.ShopMemberVo;

@WebServlet("/join.do")
public class ShopJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//회원가입 화면에 get으로 요청(회원가입 화면 띄우기 요청)이 들어오면 실행되는 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get으로 요청이 들어오면 회원가입 폼을 띄워줌
		RequestDispatcher dis = request.getRequestDispatcher("member/shopJoin.jsp");
		dis.forward(request, response);
		
	}

	
	//회원가입 화면에 post로 요청(회원가입 폼에 작성하고 회원가입을 요청)이 들어오면 실행되는 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		// 회원가입 해야되니까 db에 값넣기
		// 회원가입 페이지에 입력한 파라미터값들 받아서 저장
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		
		
		// 값을 싣을 객체 VO객체 생성 Value object
		ShopMemberVo vo = new ShopMemberVo();
		vo.setName(name);
		vo.setUserid(userid);
		vo.setPwd(pwd);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setAdmin(Integer.parseInt(admin));
		
		ShopMemberDAO mDao = ShopMemberDAO.getInstance();
		int result = mDao.insertMember(vo); 
		// 테이블에 회원을 넣어주는 memberDAO의 메서드
		
		
		// 세션 가져오기
		HttpSession session = request.getSession();
		
		if(result == 1) {
			//result값이 1이면 회원가입 성공
			// 성공하면 로그인화면에 세션 이용해서 자동으로 아이디 띄워줌
			session.setAttribute("userid", userid);
			request.setAttribute("message", "회원가입에 성공했습니다");
		} else {
			// 회원 가입 실패
			request.setAttribute("message", "회원가입에 실패했습니다");
		}
		
		//회원가입을 실행하고 로그인 화면으로 돌아감
		// 성공하면 로그인화면에 성공했습니다 뜨고 아이디 입력됨
		// 실패하면 로그인화면에 실패했습니다 뜸
		request.getRequestDispatcher("member/login.jsp")
		.forward(request, response);
	}

}
