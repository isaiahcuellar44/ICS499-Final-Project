package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@PostMapping("/saveShoppingCart")
	public ShoppingCart saveShoppingCart(@RequestBody ShoppingCart shoppingCart) {
		return shoppingCartRepository.save(shoppingCart);
	}
	
	@PostMapping("/saveManyShoppingCarts")
	public List<ShoppingCart> saveShoppingCarts(@RequestBody List<ShoppingCart> shoppingCarts) {
		return shoppingCartRepository.saveAll(shoppingCarts);
	}
}
