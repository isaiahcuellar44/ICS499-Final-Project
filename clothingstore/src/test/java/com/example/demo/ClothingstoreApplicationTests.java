package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ics499.clothingstore.ClothingstoreApplication;
import com.ics499.clothingstore.model.Customer;
import com.ics499.clothingstore.model.Guest;
import com.ics499.clothingstore.repository.CustomerRepository;
import com.ics499.clothingstore.repository.UserRepository;

@SpringBootTest(classes = ClothingstoreApplication.class)
class ClothingstoreApplicationTests {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void reposAreNotNull() {
		assertThat(userRepository).isNotNull();
	}

	@Test
	void createUsers() {
		Customer customer = new Customer("a firstname", "a lastname", "an address", "an city", 
				"a state", "a phone number", null);
		Guest guest = new Guest();
		userRepository.save(customer);
		userRepository.save(guest);
		
		Customer databaseCustomer = customerRepository.findByName("a firstname");
		assertThat(databaseCustomer).isNotNull();
		assertThat(databaseCustomer.getFirstName()).isEqualTo("a firstname");
	}

	@Test
	void addProductToCart() {
		
	}

}
