package com.shop.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.dao.ReviewDAO;
import com.shop.vo.ReviewVO;

public class ReviewListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int product_id = Integer.parseInt(request.getParameter("product_id"));
		
		List<ReviewVO> list = ReviewDAO.getInstance().selectReviewByProduct(product_id);
		request.setAttribute("ReviewList", list);
		
		for(ReviewVO lists : list) {
			System.out.println(list);
		}

		
		request.getRequestDispatcher("shop/reviewList.jsp").forward(request, response);
		
		

	}

}
