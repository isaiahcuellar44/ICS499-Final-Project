package com.ics499.clothingstore.serviceImp;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ics499.clothingstore.model.Hat;
import com.ics499.clothingstore.model.Pants;
import com.ics499.clothingstore.model.ProductReview;
import com.ics499.clothingstore.model.Shirt;
import com.ics499.clothingstore.model.Shoes;
import com.ics499.clothingstore.repository.HatRepository;
import com.ics499.clothingstore.repository.PantsRepository;
import com.ics499.clothingstore.repository.ProductRepository;
import com.ics499.clothingstore.repository.ShirtRepository;
import com.ics499.clothingstore.repository.ShoesRepository;
import com.ics499.clothingstore.service.ProductReviewService;

@Service
public class ProductReviewServiceImp implements ProductReviewService {

	@Autowired
	private ProductRepository<?> productRepository;

	@Autowired
	ShirtRepository shirtRepository;

	@Autowired
	PantsRepository pantsRepository;

	@Autowired
	ShoesRepository shoesRepository;

	@Autowired
	HatRepository hatRepository;

	public boolean saveProductReview(Map<String, String> productReview) {

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
			return true;
		} else {
			return false;
		}
	}
}
