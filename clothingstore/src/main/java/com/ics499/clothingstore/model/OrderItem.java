package com.ics499.clothingstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * A specific model to represent a item that is stored in a cart. Additional
 * information is needed for orderItems.
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */
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

	public void setProduct(Product product) {
		this.product = product;
	}

}
