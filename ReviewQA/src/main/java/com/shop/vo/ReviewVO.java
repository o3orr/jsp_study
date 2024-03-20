package com.shop.vo;

import java.sql.Date;

//CREATE TABLE Review (
//	    review_id NUMBER PRIMARY KEY,
//	    user_id NUMBER,
//	    product_id NUMBER,
//	    rating NUMBER,
//	    comment VARCHAR2(1000),
//	    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
//	    FOREIGN KEY (user_id) REFERENCES Users(user_id),
//	    FOREIGN KEY (product_id) REFERENCES Product(product_id)
//	);

public class ReviewVO {
	
	int review_id;
	int user_id;
	int product_id;
	int rating;
	String commands;
	Date created_at;
	
	public int getReview_id() {
		return review_id;
	}
	public void setReview_id(int review_id) {
		this.review_id = review_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getCommands() {
		return commands;
	}
	public void setCommands(String commands) {
		this.commands = commands;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	@Override
	public String toString() {
		return "ReviewVO [review_id=" + review_id + ", user_id=" + user_id + ", product_id=" + product_id + ", rating="
				+ rating + ", commands=" + commands + ", created_at=" + created_at + "]";
	}
	
	
	
	
}
