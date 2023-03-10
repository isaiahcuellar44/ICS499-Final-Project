package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ics499.clothingstore.ClothingstoreApplication;
import com.ics499.clothingstore.model.CartItem;
import com.ics499.clothingstore.model.Customer;
import com.ics499.clothingstore.model.Guest;
import com.ics499.clothingstore.model.Product;
import com.ics499.clothingstore.model.Shoes;
import com.ics499.clothingstore.model.ShoppingCart;
import com.ics499.clothingstore.repository.CartItemRepository;
import com.ics499.clothingstore.repository.CustomerRepository;
import com.ics499.clothingstore.repository.ProductRepository;
import com.ics499.clothingstore.repository.ShoppingCartRepository;
import com.ics499.clothingstore.repository.UserRepository;

@SpringBootTest(classes = ClothingstoreApplication.class)
class ClothingstoreApplicationTests {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private ProductRepository<?> productRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@Test
	@Order(1)
	void reposAreNotNull() {
		assertThat(userRepository).isNotNull();
	}
	
	//String firstName, String lastName, String address, String city, String state, String phoneNumber,
	//Date dateAccountCreated

	@Test
	@Order(2)
	void createUsers() {

		Guest guest = new Guest();
		
		Customer customer = new Customer("a firstname", "a lastname", "an address", "a city", 
				"a state", "a phone number", new Date());
		userRepository.save(customer);
		userRepository.save(guest);
		
		Customer databaseCustomer = customerRepository.findByName("a firstname");
		assertThat(databaseCustomer).isNotNull();
		assertThat(databaseCustomer.getFirstName()).isEqualTo("a firstname");
	}

	@Test
	@Order(3)
	void addProductToUserCart() {
		
		//add customer to db
		Customer customer = new Customer("MrCart", "a lastname", "an address", "a city", 
				"a state", "a phone number", new Date());
		//userRepository.save(customer);
		
		//get user
		//Customer dbCustomer = customerRepository.findByName("MrCart");
		
		//create user shoppingCart and set it (should be done upon construction?)
		customer.setUserCart(new ShoppingCart());
		
		//get users cart (create cart if does not exist?)
		ShoppingCart customerCart = customer.getUserCart();
		System.out.println("CART: " + customerCart);
		
		//create nike shoes
		Product nikeShoes = new Shoes();
		nikeShoes.setBrand("Nike");
		//productRepository.save(nikeShoes);
		
		//get nike shoes from repo
		//Product dbShoes = productRepository.findByBrand("Nike");
		
		//need to create a line item in db for this shoe for this customers cart
		//(for ordering 3 of this type of shoe)
		CartItem cartItem = new CartItem(customerCart, nikeShoes, 3);
		//cartItemRepository.save(cartItem);
		
		//initialize cart items (this should maybe be done on initialization?)
		customerCart.setCartItems(new ArrayList<CartItem>());
		
		//add item to customer cart
		customerCart.addToCart(cartItem);
		
		customer.setUserCart(customerCart);
		
		//add product to db
		productRepository.save(nikeShoes);
		
		//add shopping cart to db
		shoppingCartRepository.save(customerCart);
		
		//add cartitem to db
		cartItemRepository.save(cartItem);
		
		//add customer to db
		customerRepository.save(customer);
	}
}
