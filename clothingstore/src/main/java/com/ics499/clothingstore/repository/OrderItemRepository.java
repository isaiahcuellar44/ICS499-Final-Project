package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics499.clothingstore.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
