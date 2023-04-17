package com.ics499.clothingstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ics499.clothingstore.model.ProductReview;
import com.ics499.clothingstore.model.Shirt;


public interface ProductReviewRepository extends JpaRepository<ProductReview, Long>{
	@Query("SELECT r FROM ProductReview r WHERE r.product.productId = ?1")
	List<ProductReview> findByProductId(@Param("id") Long id);
}
