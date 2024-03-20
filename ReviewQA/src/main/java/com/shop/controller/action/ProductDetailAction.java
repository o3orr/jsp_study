package com.shop.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shop.dao.ProductDAO;
import com.shop.vo.ProductVO;

public class ProductDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int product_id = 1;
				//Integer.parseInt(request.getParameter("product_id"));
		
		//상품 DAO에서 값 갖고오는 코드
		ProductVO vo =  ProductDAO.getInstance().selectProductByCode(product_id);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("ProductDetail", vo);
		System.out.println(vo);
		
		//상품디테일 jsp페이지로 포워드
		request.getRequestDispatcher("shop/productDetail.jsp").forward(request, response);
	}

}
