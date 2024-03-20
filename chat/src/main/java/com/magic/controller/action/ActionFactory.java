package com.magic.controller.action;


public class ActionFactory {
	private ActionFactory() {}
	
	private static ActionFactory instance = new ActionFactory();
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println(command);
		
		if(command.equals("chat_form")) {
			action = new ChatFormAction();
		} else if(command.equals("login_form")) {
			action = new LoginFormAction();
		} else if(command.equals("chat_list")) {
			action = new ChatListAction();
		} else if(command.equals("login")) {
			action = new LoginAction();
		} else if(command.equals("chat_room")) {
			action = new ChatRoomAction();
		} else if(command.equals("chat_post")) {
			action = new ChatPostAction();
		} 
		
		
		return action;
	}
	
	
}
