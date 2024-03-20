package com.magic.dto;

import java.sql.Date;

public class MessagesVO {
	int message_id;
	int conversation_id;
	String sender_id;
	String receiver_id;
	String message_content;
	Date creation_date;
	int getMessage_id() {
		return message_id;
	}
	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}
	public int getConversation_id() {
		return conversation_id;
	}
	public void setConversation_id(int conversation_id) {
		this.conversation_id = conversation_id;
	}
	public String getSender_id() {
		return sender_id;
	}
	public void setSender_id(String sender_id) {
		this.sender_id = sender_id;
	}
	public String getReceiver_id() {
		return receiver_id;
	}
	public void setReceiver_id(String receiver_id) {
		this.receiver_id = receiver_id;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	@Override
	public String toString() {
		return "MessagesVO [message_id=" + message_id + ", conversation_id=" + conversation_id + ", sender_id="
				+ sender_id + ", receiver_id=" + receiver_id + ", message_content=" + message_content
				+ ", creation_date=" + creation_date + "]";
	}
	
	
	
}
