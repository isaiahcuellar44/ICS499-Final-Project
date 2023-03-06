package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.ShoppingCart;
import com.ics499.clothingstore.repository.ShoppingCartRepository;

@RestController
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	
	@GetMapping("/shoppingCart")
	public String test() {
		return "Shopping Cart Controller";
	}
	

	@GetMapping("/all")
	public List<ShoppingCart> list() {
		
		return shoppingCartRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ShoppingCart get(@PathVariable Long id) {
		return shoppingCartRepository.getReferenceById(id);
	}
	
	
	@PostMapping("/add")
	public ShoppingCart create(@RequestBody final ShoppingCart shoppingCart) {
//		if (shoppingCart != null) {
//			List<Course> courses = shoppingCart.getCourses();
//			for (Course course : courses) {
//				if (course != null)
//					shoppingCartRepository.saveAndFlush(course);
//			}
//		}
		return shoppingCartRepository.saveAndFlush(shoppingCart);
		
	}
	
}
