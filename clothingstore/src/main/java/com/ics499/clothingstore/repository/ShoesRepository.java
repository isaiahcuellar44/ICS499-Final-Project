package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ics499.clothingstore.model.Shirt;
import com.ics499.clothingstore.model.Shoes;


public interface ShoesRepository extends JpaRepository<Shoes, Long>{
	@Query("SELECT s FROM Shoes s WHERE s.productId = ?1")
	Shoes findByProductId(@Param("id") Long id);
}
