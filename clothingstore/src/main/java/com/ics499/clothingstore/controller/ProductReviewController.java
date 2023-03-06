package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ics499.clothingstore.model.ProductReview;
import com.ics499.clothingstore.repository.ProductReviewRepository;

@RestController
public class ProductReviewController {
	
	@Autowired
	ProductReviewRepository productReviewRepository;
	
	@GetMapping("/productReview")
	public String test() {
		return "Product Review Controller";
	}
	
	@PostMapping("/saveProductReview")
	public ProductReview saveProductReview(@RequestBody ProductReview productReview) {
		return productReviewRepository.save(productReview);
	}
	
	@PostMapping("/saveManyProductReviews")
	public List<ProductReview> saveManyProductReviews(@RequestBody List<ProductReview> productReviews) {
		return productReviewRepository.saveAll(productReviews);
	}
	
	@GetMapping("/all")
	public List<ProductReview> list() {
		return productReviewRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ProductReview get(@PathVariable Long id) {
		return productReviewRepository.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public ProductReview create(@RequestBody final ProductReview productReview) {
		return productReviewRepository.saveAndFlush(productReview);
	}
}
