package com.ics499.clothingstore.serviceImp;

import com.ics499.clothingstore.model.Order;
import com.ics499.clothingstore.model.OrderItem;
import com.ics499.clothingstore.repository.OrderRepository;

public class OrderServiceImp {

	private OrderRepository orderRepository;

	public void addToOrder(Order order, OrderItem orderItem) {
		order.addToOrder(orderItem);

	}

	public void removeFromOrder(Order order, OrderItem orderItem) {
		order.removeItem(orderItem);

	}

	public void emptyOrder(Order order) {
		order.emptyOrder();

	}

	public void saveCart(Order order) {
		orderRepository.saveAndFlush(order);

	}
}
