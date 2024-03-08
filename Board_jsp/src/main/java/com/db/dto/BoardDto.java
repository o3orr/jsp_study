package com.db.dto;

import java.sql.Date;

public class BoardDto {
	
	private int no;
	private String name;
	private String title;
	private String content;
	private Date date;
	
	
	@Override
	public String toString() {
		return "BoardDto [no=" + no + ", name=" + name + ", title=" + title + ", content=" + content + ", date=" + date
				+ "]";
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
	