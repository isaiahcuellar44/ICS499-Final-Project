package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics499.clothingstore.model.Shirt;


public interface ShirtRepository extends JpaRepository<Shirt, Long>{

}
