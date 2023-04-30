package com.ics499.clothingstore.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ics499.clothingstore.model.Order;
import com.ics499.clothingstore.model.OrderItem;
import com.ics499.clothingstore.repository.OrderRepository;
import com.ics499.clothingstore.service.OrderService;

@Service
public class OrderServiceImp implements OrderService {
	@Autowired
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

	@Override
	public void Order(com.ics499.clothingstore.model.Order order, OrderItem orderItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveOrder(com.ics499.clothingstore.model.Order order) {
		// TODO Auto-generated method stub

	}
}
