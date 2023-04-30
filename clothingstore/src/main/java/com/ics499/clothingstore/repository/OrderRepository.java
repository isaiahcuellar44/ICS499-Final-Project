package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics499.clothingstore.model.Order;

/**
 * order Repository for accessing DB
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

}
