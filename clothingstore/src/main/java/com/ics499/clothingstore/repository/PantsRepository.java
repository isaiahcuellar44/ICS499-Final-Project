package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ics499.clothingstore.model.Pants;

public interface PantsRepository extends JpaRepository<Pants, Long> {
	@Query("SELECT p FROM Pants p WHERE p.productId = ?1")
	Pants findByProductId(@Param("id") Long id);
}
