package com.ics499.clothingstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
//@author Justin Pham
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ProductController {
	@GetMapping("/product")

	public String test() {
		return "Product Controller";

	}
//	
//	
//	@GetMapping("/all")
//	public List<Product> list() {
//		return courseRepo.findAll();
//	}
//	
//	@GetMapping("{id}")
//	public Product get(@PathVariable Long id) {
//		return courseRepo.getOne(id);
//	}
//	
//	
//	@PostMapping("/add")
//	public Product create(@RequestBody final Product course) {
//		return courseRepo.saveAndFlush(course);
//		
//	}
	
}