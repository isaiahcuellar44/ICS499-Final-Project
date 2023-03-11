package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.CartItem;
import com.ics499.clothingstore.repository.CartItemRepository;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {
	
	@Autowired
	CartItemRepository cartItemRepository;
	
	@GetMapping("/test")
	public String test() {
		return "CartItem Controller";
	}
	
	@PostMapping("/save")
	public CartItem saveHat(@RequestBody CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}
	
	@PostMapping("/saveMany")
	public List<CartItem> saveManyHats(@RequestBody List<CartItem> cartItems) {
		return cartItemRepository.saveAll(cartItems);
	}
	
	@GetMapping("/all")
	public List<CartItem> list(){
		return cartItemRepository.findAll();
	}
	
	@GetMapping("{id}")
	public CartItem get(@PathVariable long id) {
		return cartItemRepository.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public CartItem create(@RequestBody final CartItem cartItem) {
		return cartItemRepository.saveAndFlush(cartItem);
	}
}
