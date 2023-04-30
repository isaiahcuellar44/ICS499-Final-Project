package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ics499.clothingstore.model.Product;

/**
 * Product Repository for accessing DB
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */
public interface ProductRepository<T extends Product> extends JpaRepository<Product, Long> {
	@Query("SELECT p FROM Product p WHERE p.brand = ?1")
	Product findByBrand(@Param("name") String brand);

	@Query("SELECT p FROM Product p WHERE p.productId = ?1")
	Product findById(@Param("name") long id);

}
