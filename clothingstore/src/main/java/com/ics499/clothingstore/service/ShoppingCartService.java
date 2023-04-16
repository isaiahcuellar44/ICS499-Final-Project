package com.ics499.clothingstore.service;

import com.ics499.clothingstore.model.CartItem;
import com.ics499.clothingstore.model.ShoppingCart;

public interface ShoppingCartService {
	public void addToCart(ShoppingCart shoppingCart, CartItem cartItem);
	public void removeFromCart(ShoppingCart shoppingCart, CartItem cartItem);
	public void emptyCart(ShoppingCart shoppingCart);
	public void saveCart(ShoppingCart shoppingCart);
	
}
