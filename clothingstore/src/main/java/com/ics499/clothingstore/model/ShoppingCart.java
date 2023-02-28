package com.ics499.clothingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue
	private long shoppingCartId;

	//causes crash, can we have a column of custom objects such as a column ShoppingCart?
	//private List<Product> products;
	
	private long userAccountId;

	public ShoppingCart(long userAccountId) {
		super();
		this.userAccountId = userAccountId;
	}

	public ShoppingCart() {

	}

	public long timeToLive() {
		return 0;
	}

	public long getUserAccountId() {
		return userAccountId;
	}

	public void setUserAccountId(long userAccountId) {
		this.userAccountId = userAccountId;
	}

	//@Override
	//public String toString() {
	//	return "ShoppingCart [products=" + products + ", userAccountId=" + userAccountId + "]";
	//}

}
