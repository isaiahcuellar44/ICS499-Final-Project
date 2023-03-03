package com.ics499.clothingstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.repository.ProductReviewRepository;

@RestController
public class ProductReviewController {
	
	@Autowired
	ProductReviewRepository productReviewRepository;
	
	@GetMapping("/productReview")
	public String test() {
		return "Product Review Controller";
	}
}
