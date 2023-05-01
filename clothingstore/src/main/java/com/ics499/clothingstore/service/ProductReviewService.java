package com.ics499.clothingstore.service;

import java.util.Map;

/**
 * Product Review Service Interface to setup implementation of service
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */
public interface ProductReviewService {
	public boolean saveProductReview(Map<String, String> productReview);
}
