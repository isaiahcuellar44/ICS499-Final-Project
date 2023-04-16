package com.ics499.clothingstore.serviceImp;

import com.ics499.clothingstore.model.CartItem;
import com.ics499.clothingstore.model.ShoppingCart;
import com.ics499.clothingstore.repository.ShoppingCartRepository;
import com.ics499.clothingstore.service.ShoppingCartService;

public class ShoppingCartServiceImp implements ShoppingCartService{
	
	private ShoppingCartRepository shoppingCartRepository;

	@Override
	public void addToCart(ShoppingCart shoppingCart, CartItem cartItem) {
		shoppingCart.addToCart(cartItem);
		
	}

	@Override
	public void removeFromCart(ShoppingCart shoppingCart, CartItem cartItem) {
		shoppingCart.removeItem(cartItem);
		
	}

	@Override
	public void emptyCart(ShoppingCart shoppingCart) {
		shoppingCart.emptyCart();
		
	}

	@Override
	public void saveCart(ShoppingCart shoppingCart) {
		shoppingCartRepository.saveAndFlush(shoppingCart);
		
	}

}
