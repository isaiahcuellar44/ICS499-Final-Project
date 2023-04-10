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
	private static final double shippingCost = 4.99;
	private boolean qualifyForReward = false; // free item if more than 100 is spent.

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;

	@OneToOne
	@JoinColumn(name = "UserID")
	private User user;

	public Order(List<OrderItem> orderItems) {
		super();
		this.orderItems = orderItems;
	}

	public Order() {
		super();
		this.orderItems = new ArrayList<OrderItem>();
	}

	public long timeToLive() {
		return 0;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
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
		for (OrderItem orderItem : orderItems) {
			total += orderItem.getProduct().getPrice();
		}
		if (total > 100) {
			qualifyForReward = true;
		}
		return total + shippingCost;

	}

}
