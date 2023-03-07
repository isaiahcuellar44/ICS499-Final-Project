package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.ShoppingCart;
import com.ics499.clothingstore.repository.ShoppingCartRepository;

@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@GetMapping("/test")
	public String test() {
		return "Shopping Cart Controller";
	}
	
	@PostMapping("/save")
	public ShoppingCart saveShoppingCart(@RequestBody ShoppingCart shoppingCart) {
		return shoppingCartRepository.save(shoppingCart);
	}
	
	@PostMapping("/saveMany")
	public List<ShoppingCart> saveShoppingCarts(@RequestBody List<ShoppingCart> shoppingCarts) {
		return shoppingCartRepository.saveAll(shoppingCarts);
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