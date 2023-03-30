package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;

import javax.transaction.Transactional;

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
import com.ics499.clothingstore.repository.RewardsRepository;
import com.ics499.clothingstore.repository.ShoppingCartRepository;
import com.ics499.clothingstore.repository.TransactionRepository;
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

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private RewardsRepository rewardsRepository;

	@Test
	@Order(1)
	void reposAreNotNull() {
		assertThat(userRepository).isNotNull();
	}

	@Test
	@Order(2)
	@Transactional
	void createUsers() {

		Guest guest = new Guest();

		Customer customer = new Customer("a firstname", "a lastname", "an address", "a city", "a state",
				"a phone number", new Date(), "an email");

		userRepository.save(customer);
		userRepository.save(guest);

		Customer databaseCustomer = customerRepository.findByFirstName("a firstname");
		assertThat(databaseCustomer).isNotNull();
		assertThat(databaseCustomer.getFirstName()).isEqualTo("a firstname");
	}

	@Test
	@Order(3)
	@Transactional
	void addProductToUserCart() {

		// issues with this test after removal of empty constructors
		/**
		 * "org.springframework.orm.jpa.JpaSystemException: No default constructor for
		 * entity: : com.ics499.clothingstore.model.CartItem; nested exception is
		 * org.hibernate.InstantiationException: No default constructor for entity: :
		 * com.ics499.clothingstore.model.CartItem
		 */

		// Create a customer
		Customer customer = new Customer("Greg", "a lastname", "an address", "a city", "a state", "a phone number",
				new Date(), "an email");

		// customerRepository.save(customer);

		// get the customers cart
		ShoppingCart customerCart = customer.getUserCart();

		// shoppingCartRepository.save(customerCart);

		// create nike shoes
		Product nikeShoes = new Shoes(0, 0, null, null, null, null, null, null);
		nikeShoes.setBrand("Nike");

		// productRepository.save(nikeShoes);

		// for ordering 3 of this type of shoe
		CartItem cartItem = new CartItem(customerCart, nikeShoes, 3);

		// cartItemRepository.save(cartItem);

		// add item to customer cart
		customerCart.addToCart(cartItem);

		// update the customers cart with changes
		customer.setUserCart(customerCart);

		// save customer to db
		customerRepository.save(customer);

		// check that user repository is not empty
		assertThat(userRepository.findAll()).isNotEmpty();

		// check that customer is in repo
		assertThat(customerRepository.findByFirstName("Greg")).isNotNull();

		// get MrCart's cart id
		long cartId = customerRepository.findByFirstName("Greg").getUserCart().getId();

		// confirm that a shopping cart with this shopping cart id is in the shopping
		// cart table
		assertThat(shoppingCartRepository.findById(cartId)).isNotEmpty();

		// check that product is in repo
		assertThat(productRepository.findAllByBrand("Nike")).isNotNull();

		// check that there is a cart item with a product id that is shared with a
		// product in the product table
		long productId = productRepository.findByBrand("Nike").getProductId();
		assertThat(cartItemRepository.findAllByProductId(productId).get(0).getProduct().getBrand().equals("Nike"));

		// check that this cart item is in this shopping cart
		assertThat(cartItemRepository.findAllByShoppingCartId(cartId).get(0).getProduct().getBrand().equals("Nike"));
	}

	@Test
	@Order(4)
	@Transactional
	void addTransactionToUser() {

		// transactions are currently being worked on

		/*
		 * //create dummy transaction Transaction transaction = new Transaction();
		 * transaction.setTotal(130);
		 * 
		 * //get a customer from repo Customer customer =
		 * customerRepository.findByFirstName("Greg");
		 * 
		 * //add transaction to the customer customer.addTransaction(transaction);
		 * 
		 * //save the new transaction customerRepository.save(customer);
		 * 
		 * //pull from repo again to confirm the transaction was applied to database
		 * customer = customerRepository.findByFirstName("Greg");
		 * 
		 * //check if the transaction is there and that the total is what we set it to
		 * before assertThat(customer.getTransactions().get(0).getTotal() == 130);
		 * 
		 * //check if the transaction was added to the database
		 * assertThat(transactionRepository.findAll()).isNotEmpty();
		 */
	}

	@Test
	@Order(5)
	void addRewardsToUser() {

		// rewards are currently being worked on

		/*
		 * //get a customer from repo Customer customer =
		 * customerRepository.findByFirstName("Greg");
		 * 
		 * customer.setRewards(new Rewards(3, 5, 10));
		 * 
		 * customerRepository.save(customer);
		 * 
		 * long rewardsId =
		 * customerRepository.findByFirstName("Greg").getRewards().getRewardsId();
		 * 
		 * assertThat(rewardsRepository.findById(rewardsId)).isNotEmpty();
		 */
	}
}