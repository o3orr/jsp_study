package com.saeyan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//create table product(
//	    code NUMBER(5) primary key,
//	    name varchar2(100) not null,
//	    price number(8) not null,
//	    pictureurl varchar2(50), 
//	    description varchar2(1000) -- 등록일
//	    );



public class ProductVO {
	@Override
	public String toString() {
		return "ProductVO [code=" + code + ", name=" + name + ", price=" + price + ", pictureUrl=" + pictureUrl
				+ ", description=" + description + "]";
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPictureUrl() {
		return pictureUrl;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private int code;
	private String name;
	private int price;
	private String pictureUrl;
	private String description;
}
