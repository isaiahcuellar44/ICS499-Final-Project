package com.ics499.clothingstore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ShoppingCart {

	@Id
	@GeneratedValue
	private long shoppingCartId;
	
	@OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
	private List<CartItem> cartItems;
	
	@OneToOne(mappedBy = "userCart", cascade = CascadeType.ALL)
	private User user;
	
	@OneToOne(mappedBy = "transactionCart", cascade = CascadeType.ALL)
	private Transaction transaction;
	
	private Date expiration;
	
	public ShoppingCart(List<CartItem> cartItems) {
		super();
		this.cartItems = cartItems;
		transaction = new Transaction();
	}
	
	public ShoppingCart() {
		super();
		this.cartItems = new ArrayList<CartItem>();
		transaction = new Transaction();
	}

	public long timeToLive() {
		return 0;
	}
	
	public void addToCart(CartItem cartItem) {
		cartItems.add(cartItem);
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	public long getShoppingCartId() {
		return shoppingCartId;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	//@Override
	//public String toString() {
	//	return "ShoppingCart [products=" + products + ", userAccountId=" + userAccountId + "]";
	//}

}
