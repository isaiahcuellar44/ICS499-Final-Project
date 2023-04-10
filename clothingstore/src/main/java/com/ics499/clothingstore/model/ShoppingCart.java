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
	private Date expiration;

	@Id
	@GeneratedValue
	private long shoppingCartId;

	@OneToMany(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
	private List<CartItem> cartItems;
	private static final double shippingCost = 4.99;
	private boolean qualifyForReward = false;

	// I want to come back to this one... Not sure how to handle this... Just
	// UserID?
	// @OneToOne(mappedBy = "userCart", cascade = CascadeType.ALL)

	@OneToOne
	@JoinColumn(name = "UserID")
	private User user;

//	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(
//			name = "CartItem",
//			joinColumns = @JoinColumn(name = "shoppingCartID"),
//			//inverseJoinColumns = @JoinColumn(name = "ProductID")
//			inverseJoinColumns = @JoinColumn(name = "CartItemID")
//			)
//	private List<CartItem> cartItems;

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

	public double orderTotal() {
		double total = 0;
		for (CartItem cartItem : cartItems) {
			total += cartItem.getProduct().getPrice();
		}
		if (total > 100) {
			qualifyForReward = true;
		}
		return total + shippingCost;

	}

	// @Override
	// public String toString() {
	// return "ShoppingCart [products=" + products + ", userAccountId=" +
	// userAccountId + "]";
	// }

}
