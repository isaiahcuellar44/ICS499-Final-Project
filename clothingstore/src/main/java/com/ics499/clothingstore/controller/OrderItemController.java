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

import com.ics499.clothingstore.model.OrderItem;
import com.ics499.clothingstore.repository.OrderItemRepository;

@RestController
@RequestMapping("/orderItem")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderItemController {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@GetMapping("/test")
	public String test() {
		return "OrderItem Controller";
	}
	
	@PostMapping("/save")
	public OrderItem saveHat(@RequestBody OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}
	
	@PostMapping("/saveMany")
	public List<OrderItem> saveManyHats(@RequestBody List<OrderItem> orderItems) {
		return orderItemRepository.saveAll(orderItems);
	}
	
	@GetMapping("/all")
	public List<OrderItem> list(){
		return orderItemRepository.findAll();
	}
	
	@GetMapping("{id}")
	public OrderItem get(@PathVariable long id) {
		return orderItemRepository.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public OrderItem create(@RequestBody final OrderItem orderItem) {
		return orderItemRepository.saveAndFlush(orderItem);
	}
	
}
