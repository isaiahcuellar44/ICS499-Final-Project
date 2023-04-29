package com.ics499.clothingstore.serviceImp;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;

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

	public void saveOrder(Order order) {
		orderRepository.saveAndFlush(order);

	}

	public void createOrder(@RequestBody Map<String, String> orderInformation) {
		String orderitems = orderInformation.get("orderItems");

	}

	public void saveJson(String jsonString) {
		Order order = new Order();
		order.setItemList(jsonString);
		orderRepository.save(order);
	}

}
