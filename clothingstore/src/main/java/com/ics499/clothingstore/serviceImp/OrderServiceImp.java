package com.ics499.clothingstore.serviceImp;

import com.ics499.clothingstore.model.Order;
import com.ics499.clothingstore.model.OrderItem;
import com.ics499.clothingstore.repository.OrderRepository;

/**
 * Order Service Implementation. Works with Controller to change, update, and
 * return data to the front end.
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */
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
