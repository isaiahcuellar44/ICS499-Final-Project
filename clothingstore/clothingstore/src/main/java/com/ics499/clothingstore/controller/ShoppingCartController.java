package com.ics499.clothingstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.repository.ShoppingCartRepository;

@RestController
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartRepository shoppingCartRepository;
	
	@GetMapping("/shoppingCart")
	public String test() {
		return "Shopping Cart Controller";
	}
}
