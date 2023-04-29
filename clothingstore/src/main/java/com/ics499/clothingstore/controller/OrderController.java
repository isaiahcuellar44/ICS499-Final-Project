package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Order;
import com.ics499.clothingstore.model.Product;
import com.ics499.clothingstore.repository.OrderRepository;
import com.ics499.clothingstore.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	@Autowired
	OrderRepository orderRepository;
	OrderService orderService;

//public long createOrder(@RequestBody Map<String, Object> orderInformation) {
	@PostMapping("/createOrder")
	public long createOrder(@RequestBody OrderRequest orderInformation) {
		List<Product> productList = orderInformation.getProducts();
		if (productList == null) {
			System.out.println("haha");
		}
		if (productList != null) {
			for (Product product : productList) {
				System.out.println(product.toString());
			}
		}
//		// createOrder - return order ID.
//		System.out.println("hi");
//		// System.out.println(orderInformation);
//		
//		for (Product product : productList) {
//			System.out.println(product.getBrand());
//		}
////		if (orderInformation.containsKey("products")) {
////			Object productsObject = orderInformation.get("products");
////
////			if (productsObject instanceof List) {
////				productList = (List<Product>) productsObject;
////			}
////		}
//
////		if (productList != null) {
////			for (Product product : productList) {
////				System.out.println(product.getBrand());
////			}
////		}

		return 90;

	}

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
