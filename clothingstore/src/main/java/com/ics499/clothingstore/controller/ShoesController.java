package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Shoes;
import com.ics499.clothingstore.repository.ShoesRepository;

@RestController
public class ShoesController {
	
	@Autowired
	ShoesRepository shoesRepository;
	
	@GetMapping("/shoes")
	public String test() {
		return "Shoes Controller";
	}
	
	@PostMapping("/saveShoes")
	public Shoes saveShoes(@RequestBody Shoes shoes) {
		return shoesRepository.save(shoes);
	}
	
	@PostMapping("/saveManyShoes")
	public List<Shoes> saveManyShoes(@RequestBody List<Shoes> shoes) {
		return shoesRepository.saveAll(shoes);
	}
}
