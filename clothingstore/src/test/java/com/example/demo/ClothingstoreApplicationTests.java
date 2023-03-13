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
				"a state", "a phone number", new Date(), "an email");
		userRepository.save(customer);
		userRepository.save(guest);
		
		Customer databaseCustomer = customerRepository.findByName("a firstname");
		assertThat(databaseCustomer).isNotNull();
		assertThat(databaseCustomer.getFirstName()).isEqualTo("a firstname");
	}

	@Test
	@Order(3)
	void addProductToUserCart() {
		//Create a customer
		Customer customer = new Customer("MrCart", "a lastname", "an address", "a city", 
				"a state", "a phone number", new Date(), "an email");
		
		//get the customers cart
		ShoppingCart customerCart = customer.getUserCart();
		
		//create nike shoes
		Product nikeShoes = new Shoes();
		nikeShoes.setBrand("Nike");
		
		//for ordering 3 of this type of shoe
		CartItem cartItem = new CartItem(customerCart, nikeShoes, 3);
		
		//add item to customer cart
		customerCart.addToCart(cartItem);
		
		//update the customers cart with changes
		customer.setUserCart(customerCart);
		
		//(all these were needed before CascadeType.ALL)
			//add product to db
			//productRepository.save(nikeShoes);
			
			//add shopping cart to db
			//shoppingCartRepository.save(customerCart);
			
			//add cartitem to db
			//cartItemRepository.save(cartItem);
		
		//save customer to db
		customerRepository.save(customer);
		
		//check that user repository is not empty
		assertThat(userRepository.findAll()).isNotNull();
		
		//check that customer is in repo
		assertThat(customerRepository.findByName("MrCart")).isNotNull();
		
		//get MrCart shopping cart id
		//TODO need a SQL statement in customer repo to find a customer's cart given first name
		
		//confirm that a shopping cart with this shopping cart id is in the shopping cart table
		//assertThat(shoppingCartRepository.findAllById(cartId)).isNotNull();
		
		//check that product is in repo
		assertThat(productRepository.findByBrand("Nike")).isNotNull();
		
		//check that there is a cart item in the repo that matches the product
		//TODO need a SQL statement in cart item repo to get a cart item based on a given product ID
	}
	
	@Test
	@Order(4)
	void addTransactionToUser() {
	}
	
	@Test
	@Order(5)
	void submitOrder() {
		//add transaction to transaction history for user
		
		//clear cart items for this user
	}
	
	@Test
	@Order(6)
	void addRewardsToUser() {
	}
}
