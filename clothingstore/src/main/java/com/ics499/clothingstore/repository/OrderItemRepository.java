package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics499.clothingstore.model.OrderItem;

/**
 * Order Item Repository for accessing DB
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
