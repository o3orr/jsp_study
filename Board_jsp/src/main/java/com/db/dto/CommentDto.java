package com.db.dto;

import java.sql.Date;

//create table Boardcomment(
//	    comnum number primary key,
//	    content varchar2(2000) not null,
//	    day date default sysdate not null,
//	    pagenum number not null REFERENCES board(no)
//	    );

public class CommentDto {
	private int comnum;
	private String content;
	private Date day;
	private int pagenum;
	public int getComnum() {
		return comnum;
	}
	public void setComnum(int comnum) {
		this.comnum = comnum;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "CommentDto [comnum=" + comnum + ", content=" + content + ", day=" + day + ", pagenum=" + pagenum + "]";
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	public int getPagenum() {
		return pagenum;
	}
	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

}
