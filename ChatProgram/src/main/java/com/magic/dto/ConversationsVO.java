package com.magic.dto;

import java.sql.Date;

//CREATE TABLE conversations (
//	    conversation_id VARCHAR2(20) NOT NULL,
//	    creation_date DATE DEFAULT SYSDATE,
//	    participant1_id VARCHAR2(10) REFERENCES employees(id),
//	    participant2_id VARCHAR2(10) REFERENCES employees(id),
//	    PRIMARY KEY (conversation_id)
//	);

public class ConversationsVO {
	int conversation_id;
	Date creation_date;
	String participant1_id;
	String participant2_id;
	int getConversation_id() {
		return conversation_id;
	}
	public void setConversation_id(int conversation_id) {
		this.conversation_id = conversation_id;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public String getParticipant1_id() {
		return participant1_id;
	}
	public void setParticipant1_id(String participant1_id) {
		this.participant1_id = participant1_id;
	}
	public String getParticipant2_id() {
		return participant2_id;
	}
	public void setParticipant2_id(String participant2_id) {
		this.participant2_id = participant2_id;
	}
	@Override
	public String toString() {
		return "ConversationsVO [conversation_id=" + conversation_id + ", creation_date=" + creation_date
				+ ", participant1_id=" + participant1_id + ", participant2_id=" + participant2_id + "]";
	}
	
	
	
	
	
}
