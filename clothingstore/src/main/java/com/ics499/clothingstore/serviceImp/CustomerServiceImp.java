package com.ics499.clothingstore.serviceImp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ics499.clothingstore.model.Customer;
import com.ics499.clothingstore.repository.CustomerRepository;
import com.ics499.clothingstore.service.CustomerService;

@SpringBootApplication
public class CustomerServiceImp implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean isValid(String username, String password) {

		Customer foundCustomer = customerRepository.findByFirstName(username);

		if (foundCustomer == null) {
			System.out.println("Customer does not exist");
			return false;
		}

		if (foundCustomer.getEmail().equals(username) && foundCustomer.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	public String createCustomer(String firstName, String lastName, String address, String city, String state,
			String phoneNumber, String email) {
		Date d1 = new Date();
//		Customer newCustomer = new Customer(firstName, lastName, address, city, state, phoneNumber, d1, email);
		Customer newCustomer = new Customer();
		customerRepository.save(newCustomer);
		return "Customer Created";
	}

}
