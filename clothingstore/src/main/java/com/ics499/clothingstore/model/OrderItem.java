package com.ics499.clothingstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue
	private long orderItemId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "OrderID")
	private Order order;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ProductID")
	private Product product;

	private int quantity;

	public OrderItem(Order order, Product product, int quantity) {
		super();
		this.order = order;
		this.product = product;
		this.setQuantity(quantity);
	}

	public OrderItem() {
		super();
	}

	public long getOrderItemId() {
		return orderItemId;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public Product setProduct(Product p) {
		return this.product;
	}
}
