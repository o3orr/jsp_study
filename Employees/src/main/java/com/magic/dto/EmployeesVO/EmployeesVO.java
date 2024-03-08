package com.magic.dto.EmployeesVO;

import java.sql.Date;

//create table employees(
//	    id varchar2(10) not null,
//	    pass varchar2(10) not null,
//	    name varchar2(24),
//	    lev char(1) DEFAULT 'A', -- A:운영자, B:일반회원
//	    enter date default sysdate, -- 등록일
//	    gender char(1) default '1', -- 1: 남자, 2:여자
//	    phone varchar2(30),
//	    primary key(id)
//	    );

public class EmployeesVO {
	private String id;
	private String pass;
	private String name;
	private String lev;
	private Date enter;
	private String gender;
	private String phone;
	
	@Override
	public String toString() {
		return "EmployeesVO [id=" + id + ", pass=" + pass + ", name=" + name + ", lev=" + lev + ", enter=" + enter
				+ ", gender=" + gender + ", phone=" + phone + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLev() {
		return lev;
	}
	public void setLev(String lev) {
		this.lev = lev;
	}
	public Date getEnter() {
		return enter;
	}
	public void setEnter(Date enter) {
		this.enter = enter;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
