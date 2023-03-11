package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//@author Justin Pham
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Hat;
import com.ics499.clothingstore.model.Product;
import com.ics499.clothingstore.repository.ProductRepository;

@RestController
@RequestMapping("product")
public class ProductController {
	@Autowired
	ProductRepository<Hat> productRepository;

	@GetMapping("/test")
	public String test() {
		return "Product Controller";
	}
	
	
	@GetMapping("/all")
	public List<Product> list() {
		return productRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Product get(@PathVariable Long id) {
		return productRepository.getReferenceById(id);
	}
	
	
	@PostMapping("/add")
	public Product create(@RequestBody final Product course) {
		return productRepository.saveAndFlush(course);
		
	}
	
}