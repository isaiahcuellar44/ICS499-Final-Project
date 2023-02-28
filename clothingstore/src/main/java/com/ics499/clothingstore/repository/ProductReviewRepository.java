package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics499.clothingstore.model.ProductReview;


public interface ProductReviewRepository extends JpaRepository<ProductReview, Long>{

}
