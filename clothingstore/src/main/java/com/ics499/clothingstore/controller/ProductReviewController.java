package com.ics499.clothingstore.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Hat;
import com.ics499.clothingstore.model.Pants;
import com.ics499.clothingstore.model.ProductReview;
import com.ics499.clothingstore.model.Shirt;
import com.ics499.clothingstore.model.Shoes;
import com.ics499.clothingstore.repository.HatRepository;
import com.ics499.clothingstore.repository.PantsRepository;
import com.ics499.clothingstore.repository.ProductRepository;
import com.ics499.clothingstore.repository.ProductReviewRepository;
import com.ics499.clothingstore.repository.ShirtRepository;
import com.ics499.clothingstore.repository.ShoesRepository;

/**
 * Product Review Controller, used to send information to Angular Front end.
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */

@RestController
@RequestMapping("/productReview")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductReviewController {

	@Autowired
	ProductReviewRepository productReviewRepository;

	@Autowired
	ProductRepository<?> productRepository;

	@Autowired
	ShirtRepository shirtRepository;

	@Autowired
	PantsRepository pantsRepository;

	@Autowired
	ShoesRepository shoesRepository;

	@Autowired
	HatRepository hatRepository;

	@GetMapping("/test")
	public String test() {
		return "Product Review Controller";
	}

	@PostMapping("/save")
	public ProductReview saveProductReview(@RequestBody ProductReview productReview) {
		return productReviewRepository.save(productReview);
	}

	@PostMapping("/saveProductReview")
	public boolean saveProductReview(@RequestBody Map<String, String> productReview) {

		System.out.println("In save product review");

		System.out.println(productReview);

		// get product with the given ID
		long productId = Long.parseLong(productReview.get("productId"));
		var productToSave = productRepository.findById(productId);

		if (productToSave != null) {

			// create product review object with infomration
			// Product product, int rating, long userAccountID, String review
			ProductReview newReview = new ProductReview(productToSave, Integer.parseInt(productReview.get("rating")),
					Long.parseLong(productReview.get("userId")), productReview.get("review"),
					productReview.get("username"));

			// add review to product
			productToSave.addProductReview(newReview);

			// save product to repo
			if (productToSave instanceof Shirt) {
				shirtRepository.save((Shirt) productToSave);
			} else if (productToSave instanceof Hat) {
				hatRepository.save((Hat) productToSave);
			} else if (productToSave instanceof Shoes) {
				shoesRepository.save((Shoes) productToSave);
			} else if (productToSave instanceof Pants) {
				pantsRepository.save((Pants) productToSave);
			}
			System.out.println("success");
			return true;
		} else {
			System.out.println("failure");
			return false;
		}
	}

	@GetMapping("/all")
	public List<ProductReview> list() {
		return productReviewRepository.findAll();
	}

	/*
	 * @PostMapping("/addToProduct") public boolean login(@RequestBody Map<String,
	 * String> reviewInformation) {
	 * if(customerService.createCustomer(customerInformation.get("username"),
	 * customerInformation.get("password"), customerInformation.get("firstName"),
	 * customerInformation.get("lastName"), customerInformation.get("email"))) {
	 * return true; } else { return false; } }
	 */

	@GetMapping("/getById/{id}")
	public List<ProductReview> getById(@PathVariable Long id) {
		System.out.println("getting reviews for product " + id);

		List<ProductReview> foundReviews = productReviewRepository.findByProductId(id);

		for (var review : foundReviews) {
			System.out.println(review.getUsername());
		}

		System.out.println(foundReviews);

		return foundReviews;
	}

	@GetMapping("{id}")
	public ProductReview getReviewsByProdId(@PathVariable Long id) {
		return productReviewRepository.getReferenceById(id);
	}

	@PostMapping("/add")
	public ProductReview create(@RequestBody final ProductReview productReview) {
		return productReviewRepository.saveAndFlush(productReview);
	}
}
