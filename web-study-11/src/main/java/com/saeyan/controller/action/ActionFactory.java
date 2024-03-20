package com.saeyan.controller.action;

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
		
		if(command.equals("board_list")) {
			//들어온 요청이 board_list면 /board/boardList.jsp"를 반환하는 객체 반환
			action = new BoardListAction();
		} else if(command.equals("board_write_form")) {
			action = new BoardWriteActionForm();
		} else if(command.equals("board_write")) {
			//post방식 요청
			action = new BoardWriteAction();
		} else if(command.equals("board_view")) {
			action = new BoardViewAction();
		} else if(command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		} else if(command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		} else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		} else if(command.equals("board_update")) {
			action = new BoardUpdateAction();
		} else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
		} 
		
		return action;
	}
}
