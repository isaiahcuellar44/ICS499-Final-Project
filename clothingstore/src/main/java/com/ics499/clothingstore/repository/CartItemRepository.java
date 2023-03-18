package com.ics499.clothingstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ics499.clothingstore.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	@Query("SELECT c FROM CartItem c WHERE c.product.productId = ?1")
	List<CartItem> findAllByProductId(@Param("productId") long productId);
	
	@Query("SELECT c FROM CartItem c WHERE c.shoppingCart.shoppingCartId = ?1")
	List<CartItem> findAllByShoppingCartId(@Param("shoppingCartId") long shoppingCartId);
}
