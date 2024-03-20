package com.shop.vo;

import java.sql.Date;

//create table product(
//	    product_id NUMBER(5) PRIMARY KEY,
//	    product_name VARCHAR2(100),
//	    category VARCHAR2(50),
//	    price NUMBER(7),
//	    stock_quantity NUMBER(5),
//	    description VARCHAR2(500),
//	    created_date DATE DEFAULT SYSDATE
//	);

public class ProductVO {
	int product_id;
	String product_name;
	String category;
	int price;
	int stock_quantity;
	String description;
	Date created_date;
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock_quantity() {
		return stock_quantity;
	}
	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	@Override
	public String toString() {
		return "ProductVO [product_id=" + product_id + ", product_name=" + product_name + ", category=" + category
				+ ", price=" + price + ", stock_quantity=" + stock_quantity + ", description=" + description
				+ ", created_date=" + created_date + "]";
	}
	
	
}
