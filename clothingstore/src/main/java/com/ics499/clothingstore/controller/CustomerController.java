package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Customer;
import com.ics499.clothingstore.repository.CustomerRepository;
import com.ics499.clothingstore.serviceImp.CustomerServiceImp;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerServiceImp test;

	public String customerPage() {
		return "Customer Page";

	}

	@GetMapping("/test")
	public String test() {

		test.isValid("123@email.com", "abc123");
		return "Customer Controller";
	}

	@GetMapping("/creatCustomer")
	public String createCustomer() {
//		String firstName, String lastName, String address, String city, String state,
//		String phoneNumber, String email
		test.createCustomer("bob", "Anderson", "street", "City town", "AL", "555-555-5555", "bAnderson@email.com");
		return "Customer Created";
	}

	@PostMapping("/save")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	@PostMapping("/saveMany")
	public List<Customer> saveManyCustomers(@RequestBody List<Customer> customers) {
		return customerRepository.saveAll(customers);
	}

	@GetMapping("/all")
	public List<Customer> list() {
		return customerRepository.findAll();
	}

	@GetMapping("{id}")
	public Customer get(@PathVariable Long id) {
		return customerRepository.getReferenceById(id);
	}

	@PostMapping("/add")
	public Customer create(@RequestBody final Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}

}
