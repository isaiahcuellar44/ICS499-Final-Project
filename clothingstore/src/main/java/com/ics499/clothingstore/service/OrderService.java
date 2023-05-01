package com.ics499.clothingstore.service;

import java.util.Map;

import com.ics499.clothingstore.model.Order;
import com.ics499.clothingstore.model.OrderItem;

/**
 * Order Service Interface to setup implementation of service
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */
public interface OrderService {
	public void addToOrder(Order order, OrderItem orderItem);

	public void emptyOrder(Order order);

	public long createOrder(Map<String, Object> orderInformation);
}
