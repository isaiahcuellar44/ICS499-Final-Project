package com.ics499.clothingstore.service;

/**
 *Order Service Interface to setup implementation of service
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */

import com.ics499.clothingstore.model.Order;
import com.ics499.clothingstore.model.OrderItem;

public interface OrderService {
	public void addToOrder(Order order, OrderItem orderItem);

	public void Order(Order order, OrderItem orderItem);

	public void emptyOrder(Order order);

	public void saveOrder(Order order);
}
