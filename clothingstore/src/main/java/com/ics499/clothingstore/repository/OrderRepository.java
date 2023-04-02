package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics499.clothingstore.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
