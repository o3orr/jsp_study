package com.shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/login.do")
public class ShopLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// login.do으로 get방식으로 접속하면 login.jsp로 연결해주는 역할
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dis = request.getRequestDispatcher("member/shopLogin.jsp");
		dis.forward(request, response);
		
	}

	// login.do로 post방식으로 접속하면 연결해주는 역할
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
