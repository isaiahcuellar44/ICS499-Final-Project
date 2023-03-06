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

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerRepository customerRepository;
	
	@GetMapping("/customer")
	public String test() {
		return "Customer Controller";
	}
	
	@PostMapping("/saveCustomer")
	public Customer saveCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	@PostMapping("/saveManyCustomers")
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
