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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Order Model, represents a created order when a purchase is made then sent to
 * the DB.
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */

@Entity
public class Order {

	@Id
	@GeneratedValue
	private long orderId;

	private String billingName;
	private String address;
	private String city;
	private String state;
	private int zip;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<OrderItem> orderItems;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserID")
	private User user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "transactionId")
	private Transaction transaction;

	public Order(List<OrderItem> orderItems) {
		super();
		this.orderItems = orderItems;
	}

	public Order(String billingName, String address, String city, String state, int zip) {
		super();
		this.billingName = billingName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.orderItems = new ArrayList<OrderItem>();
	}

	public Order() {
		super();
		this.orderItems = new ArrayList<OrderItem>();
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public String getBillingName() {
		return billingName;
	}

	public void setBillingName(String billingName) {
		this.billingName = billingName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
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

	public void addToOrder(OrderItem orderItem) {
		this.orderItems.add(orderItem);
	}

	public void emptyOrder() {
		this.orderItems.clear();
	}

	public void removeItem(OrderItem orderItem) {
		this.orderItems.remove(orderItem);

	}

}
