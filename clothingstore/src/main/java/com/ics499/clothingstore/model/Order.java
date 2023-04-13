package com.ics499.clothingstore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Order {

	@Id
	@GeneratedValue
	private long orderId;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<Product> orderItems;
	private static final double shippingCost = 4.99;
	private boolean qualifyForReward = false;

	@OneToOne
	@JoinColumn(name = "UserID")
	private User user;

	public Order(List<Product> cartItems) {
		super();
		this.orderItems = cartItems;

	}

	public Order() {
		super();
		this.orderItems = new ArrayList<Product>();
	}

	public long timeToLive() {
		return 0;
	}

	public List<Product> getOrderItems() {
		return orderItems;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public void setOrderItems(List<Product> orderItems) {
		this.orderItems = orderItems;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public long getId() {
		return this.orderId;
	}

	public double orderTotal() {
		double total = 0;
		for (Product orderItem : orderItems) {
			total += orderItem.getPrice();
		}
		if (total > 100) {
			qualifyForReward = true;
		}
		return total + shippingCost;

	}

}
