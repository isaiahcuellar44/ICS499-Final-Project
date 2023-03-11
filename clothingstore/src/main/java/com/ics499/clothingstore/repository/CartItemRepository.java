package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics499.clothingstore.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
