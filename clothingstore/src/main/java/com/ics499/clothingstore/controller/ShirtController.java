package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Shirt;
import com.ics499.clothingstore.repository.ShirtRepository;

@RestController
public class ShirtController {
	
	@Autowired
	ShirtRepository shirtRepository;
	
	@GetMapping("/shirt")
	public String test() {
		return "Shirt Controller";
	}
	
	@PostMapping("/saveShirt")
	public Shirt saveShirt(@RequestBody Shirt shirt) {
		return shirtRepository.save(shirt);
	}
	
	@PostMapping("/saveManyShirts")
	public List<Shirt> saveManyShirts(@RequestBody List<Shirt> shirts) {
		return shirtRepository.saveAll(shirts);
	}
}
