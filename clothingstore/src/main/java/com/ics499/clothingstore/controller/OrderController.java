package com.ics499.clothingstore.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
<<<<<<< Updated upstream
=======
import java.util.Map;
>>>>>>> Stashed changes

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Hat;
import com.ics499.clothingstore.model.Order;
import com.ics499.clothingstore.model.OrderItem;
import com.ics499.clothingstore.model.Pants;
import com.ics499.clothingstore.model.Shirt;
import com.ics499.clothingstore.model.Shoes;
import com.ics499.clothingstore.model.Transaction;
import com.ics499.clothingstore.repository.OrderRepository;
import com.ics499.clothingstore.repository.ProductRepository;
import com.ics499.clothingstore.serviceImp.OrderServiceImp;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
<<<<<<< Updated upstream
	
=======
	@Autowired
	ProductRepository productRepository;
	@Autowired
	OrderServiceImp orderService = new OrderServiceImp();

//public long createOrder(@RequestBody Map<String, Object> orderInformation) {
	@SuppressWarnings("unchecked")
	@PostMapping("/createOrder")
	public long createOrder(@RequestBody Map<String, Object> orderInformation, String custID) {
		LinkedHashMap<String, Object> orderMap = (LinkedHashMap<String, Object>) orderInformation.get("orderItems");
		ArrayList<LinkedHashMap<String, String>> orderProducts = (ArrayList<LinkedHashMap<String, String>>) orderMap
				.get("products");
		System.out.println(custID);
		Order order = new Order();
		Transaction transaction = new Transaction("0", "0", 0, new Date(), 0, new Date(), false);
		transaction.setTotal((double) orderMap.get("totalCost"));
		order.setTransaction(transaction);

		for (LinkedHashMap<String, String> prod : orderProducts) {
			long productId = Long.parseLong(String.valueOf(prod.get("productId")));
			var product = productRepository.findById(productId);
			OrderItem orderItem = new OrderItem();

			orderItem.setOrder(order);
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
		}
		System.out.println(order.getId());
		orderService.saveCart(order);
		return order.getId();
	}

>>>>>>> Stashed changes
	@GetMapping("/test")
	public String test() {
		return "Order Controller";
	}

	@PostMapping("/save")
	public Order saveOrder(@RequestBody Order order) {
		return orderRepository.save(order);
	}

	@PostMapping("/saveMany")
	public List<Order> saveOrders(@RequestBody List<Order> order) {
		return orderRepository.saveAll(order);
	}

	@GetMapping("/all")
	public List<Order> list() {

		return orderRepository.findAll();
	}

	@GetMapping("{id}")
	public Order get(@PathVariable Long id) {
		return orderRepository.getReferenceById(id);
	}

}
