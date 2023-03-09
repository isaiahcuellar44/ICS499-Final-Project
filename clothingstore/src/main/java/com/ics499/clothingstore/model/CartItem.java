package com.ics499.clothingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CartItem {
	
	@Id
	@GeneratedValue
	private long cartItemId;
	
	@ManyToOne
	@JoinColumn
	private ShoppingCart shoppingCart;
	
	@ManyToOne
	private Product product;
	
	private int quantity;
	
	public CartItem(ShoppingCart shoppingCart, Product product, int quantity) {
		super();
		this.shoppingCart = shoppingCart;
		this.product = product;
		this.quantity = quantity;
	}
	
	public CartItem() { }
}
