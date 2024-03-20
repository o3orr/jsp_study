package com.shop.controller.action;


public class ActionFactory {
	private ActionFactory() {}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
						//board_list가 전달됨
	public Action getAction(String command) {
		//파라미터로 받아온 command로 어디 java파일로 이동할지 결정
		Action action = null;
		
		System.out.println(command);
		//action구현 클래스
		
		if (command.equals("product_detail")) {
			action = new ProductDetailAction();
		} else if (command.equals("review_list")) {
			action = new ReviewListAction();
		}
		
		
		return action;
	}
}

