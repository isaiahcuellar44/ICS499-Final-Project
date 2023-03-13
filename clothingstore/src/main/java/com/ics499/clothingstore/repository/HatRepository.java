package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics499.clothingstore.model.Hat;

public interface HatRepository extends JpaRepository<Hat, Long> {
//	@Query("SELECT h FROM Hat p WHERE p.brand = ?1")
//	Hat findByBrand(@Param("brand") String brand);

}
