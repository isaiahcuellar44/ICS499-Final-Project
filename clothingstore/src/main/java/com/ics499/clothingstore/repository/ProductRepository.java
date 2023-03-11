package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics499.clothingstore.model.Product;

public interface ProductRepository<T extends Product> extends JpaRepository<Product, Long>{

}
