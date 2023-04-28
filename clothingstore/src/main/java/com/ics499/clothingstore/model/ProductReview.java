package com.ics499.clothingstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductReview {

	@Id
	@GeneratedValue
	private long reviewId;
	private int rating;
	private long userAccountID;
	private String username;
	private String review;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	Product product;

	public ProductReview(Product product, int rating, long userAccountID, String review, String username) {
		super();
		this.product = product;
		this.rating = rating;
		this.userAccountID = userAccountID;
		this.review = review;
		this.username = username;
	}
	
	public ProductReview() {
		
	}

	public Product getProduct() {
		return product;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public long getProductId() {
		return this.product.getProductId(); // -- TomW 
	}

//	public void setProductId(long productId) {
//		this.productId = productId;
//	}

	public long getId() {
		return this.reviewId;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public long getUserAccountID() {
		return userAccountID;
	}

	public void setUserAccountID(long userAccountID) {
		this.userAccountID = userAccountID;
	}

	public String getReview() {// these two are the same as show review and make review
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	/*
	@Override
	public String toString() {
		return "ProductReview [product=" + product + ", rating=" + rating + ", userAccountID=" + userAccountID
				+ ", review=" + review + "]";
	}
	*/

}
