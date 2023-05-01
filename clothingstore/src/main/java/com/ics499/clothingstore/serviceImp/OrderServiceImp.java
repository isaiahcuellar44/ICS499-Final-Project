package com.ics499.clothingstore.serviceImp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ics499.clothingstore.model.Customer;
import com.ics499.clothingstore.model.Guest;
import com.ics499.clothingstore.model.Hat;
import com.ics499.clothingstore.model.Order;
import com.ics499.clothingstore.model.OrderItem;
import com.ics499.clothingstore.model.Pants;
import com.ics499.clothingstore.model.Shirt;
import com.ics499.clothingstore.model.Shoes;
import com.ics499.clothingstore.model.Transaction;
import com.ics499.clothingstore.repository.CustomerRepository;
import com.ics499.clothingstore.repository.OrderRepository;
import com.ics499.clothingstore.repository.ProductRepository;
import com.ics499.clothingstore.service.OrderService;

/**
 * Order Service Implementation. Works with Controller to change, update, and
 * return data to the front end.
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */
@Service
public class OrderServiceImp implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository<?> productRepository;

	@Autowired
	private CustomerRepository customerRepository;

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

	/**
	 * creates a order. this needs to gather info from a JSON file and converts it
	 * accordingly.
	 */
	@SuppressWarnings("unchecked")
	public long createOrder(Map<String, Object> orderInformation) {
		LinkedHashMap<String, Object> orderMap = (LinkedHashMap<String, Object>) orderInformation.get("orderItems");
		ArrayList<LinkedHashMap<String, String>> orderProducts = (ArrayList<LinkedHashMap<String, String>>) orderMap
				.get("products");

		LinkedHashMap<String, String> checkoutInfo = (LinkedHashMap<String, String>) orderInformation
				.get("checkoutInfo");

		Order order = new Order(checkoutInfo.get("billingName"), checkoutInfo.get("address"), checkoutInfo.get("city"),
				checkoutInfo.get("state"), Integer.parseInt(checkoutInfo.get("zip")));

		String dateString = String.format("%02d/%04d", Integer.parseInt(checkoutInfo.get("expMonth")),
				Integer.parseInt(checkoutInfo.get("expYear")));
		SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
		Date expirationDate = null;
		try {
			expirationDate = formatter.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Transaction transaction = new Transaction(checkoutInfo.get("cardNum"), checkoutInfo.get("cardName"),
				Integer.parseInt(checkoutInfo.get("cvv")), expirationDate, (double) orderMap.get("totalCost"),
				new Date());

		order.setTransaction(transaction);
		transaction.setOrder(order);

		for (LinkedHashMap<String, String> prod : orderProducts) {
			long productId = Long.parseLong(String.valueOf(prod.get("productId")));
			var product = productRepository.findById(productId);
			OrderItem orderItem = new OrderItem();

			orderItem.setQuantity(Integer.parseInt(String.valueOf(prod.get("quantity"))));

			if (product instanceof Shirt) {
				orderItem.setProduct((Shirt) product);
			} else if (product instanceof Hat) {
				orderItem.setProduct((Hat) product);
			} else if (product instanceof Shoes) {
				orderItem.setProduct((Shoes) product);
			} else if (product instanceof Pants) {
				orderItem.setProduct((Pants) product);
			}

			orderItem.setOrder(order);
			order.addToOrder(orderItem);
		}

		if (orderInformation.get("username") == null) {
			Customer foundCustomer = customerRepository
					.findByUsername(String.valueOf(orderInformation.get("username")));
			order.setUser(foundCustomer);
		} else {
			order.setUser(new Guest());
		}

		Order savedOrder = orderRepository.save(order);
		return savedOrder.getId();
	}

}
