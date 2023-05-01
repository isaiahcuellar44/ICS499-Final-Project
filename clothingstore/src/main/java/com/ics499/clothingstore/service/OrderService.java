package com.ics499.clothingstore.service;

import java.util.Map;

import com.ics499.clothingstore.model.Order;
import com.ics499.clothingstore.model.OrderItem;

public interface OrderService {
	public void addToOrder(Order order, OrderItem orderItem);

	public void Order(Order order, OrderItem orderItem);

	public void emptyOrder(Order order);

	public void saveOrder(Order order);

	public long createOrder(Map<String, Object> orderInformation);
}
