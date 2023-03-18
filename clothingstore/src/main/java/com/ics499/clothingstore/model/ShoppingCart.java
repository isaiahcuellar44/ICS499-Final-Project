package com.ics499.clothingstore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ShoppingCart {
	private Date expiration;
	
	@Id
	@GeneratedValue
	private long shoppingCartId;
	
//	@OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
//	private List<CartItem> cartItems;
//	
	
	
	
	// I want to come back to this one... Not sure how to handle this... Just UserID?
	//@OneToOne(mappedBy = "userCart", cascade = CascadeType.ALL)
	
	@JsonIgnore
	@OneToOne
	@JoinColumn (name = "UserID")
	private User user;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(
			name = "CartItem",
			joinColumns = @JoinColumn(name = "shoppingCartID"),
			inverseJoinColumns = @JoinColumn(name = "ProductID")
			)
	private List<CartItem> cartItems;
	
	
	public ShoppingCart(List<CartItem> cartItems) {
		super();
		this.cartItems = cartItems;
	}
	
	public ShoppingCart() {
		super();
		this.cartItems = new ArrayList<CartItem>();
	}

	public long timeToLive() {
		return 0;
	}
	
	public void addToCart(CartItem cartItem) {
		cartItems.add(cartItem);
	}
	
	public void removeItem(CartItem cartItem) {
		cartItems.remove(cartItem);
	}
	
	public void emptyCart() {
		cartItems.clear();
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
	
	public long getId() {
		return this.shoppingCartId;
	}
	
	
	//@Override
	//public String toString() {
	//	return "ShoppingCart [products=" + products + ", userAccountId=" + userAccountId + "]";
	//}

}
