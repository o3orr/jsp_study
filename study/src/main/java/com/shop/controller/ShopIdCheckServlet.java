package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.ShopMemberDAO;


// 아이디 중복체크버튼 누르면 띄워지는 창의 주소
@WebServlet("/idCheck.do")
public class ShopIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		// get방식으로 들어온 파라미터 받음
		String userid = request.getParameter("userid");
		
		//데이터베이스에서 아이디 있는지 확인하기 위해서 data access object 객체를 생성
		ShopMemberDAO mDao = ShopMemberDAO.getInstance();
		int result = mDao.confirmID(userid); 
		// DAO에 있는 메서드로 중복체크해서 result에 값 저장
		
		// 아이디 중복체크할때 적은 id담음
		request.setAttribute("userid", userid);
		// confirmID해서 리턴된 값 담음 1아니면 -1
		request.setAttribute("result", result);
		
	
		RequestDispatcher dis = request.getRequestDispatcher("member/shopIdcheck.jsp");
		dis.forward(request, response);				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
