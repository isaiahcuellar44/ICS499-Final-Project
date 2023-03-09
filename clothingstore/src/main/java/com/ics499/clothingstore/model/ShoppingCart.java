package com.ics499.clothingstore.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue
	private long shoppingCartId;
	
	@OneToMany(mappedBy = "shoppingCart")
	private List<CartItem> cartItems;
	
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
