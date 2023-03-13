package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ics499.clothingstore.model.Product;

public interface ProductRepository<T extends Product> extends JpaRepository<Product, Long> {
	@Query("SELECT p FROM Product p WHERE p.brand = ?1")
	Product findByBrand(@Param("name") String brand);

	@Query("SELECT p FROM Product p WHERE p.productId = ?1")
	Product findById(@Param("name") long id);

//	@Query("Insert INTO Product(price, stock, description, brand, color, size, fit, type) VALUES(?,?,?,?,?,?,?,?)")
//	Product addHat(@Param("price") float price, @Param("description") String description, @Param("brand") String brand,
//			@Param("color") String color, @Param("size") String size, @Param("fit") String fit,
//			@Param("type") HatType type);

}
