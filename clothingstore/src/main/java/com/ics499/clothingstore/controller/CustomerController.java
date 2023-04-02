package com.ics499.clothingstore.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Customer;
import com.ics499.clothingstore.repository.CustomerRepository;
import com.ics499.clothingstore.service.CustomerService;
import com.ics499.clothingstore.serviceImp.CustomerServiceImp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	CustomerServiceImp test;
	@Autowired
	CustomerService customerService;

	public String customerPage() {
		return "Customer Page";

	}

	@GetMapping("/test")
	public String test() {

		test.isValid("123@email.com", "abc123");
		return "Customer Controller";
	}

	@PostMapping("/login")
	public boolean login(@RequestBody String jsonDataDto) throws JsonMappingException, JsonProcessingException {
		// Validate the user's credentials
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(jsonDataDto);
		
		String username = jsonNode.get("username").asText();
		String password = jsonNode.get("password").asText();
		
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		
		if (customerService.isValid(username, password)) {
			// Set up the session
			// session.setAttribute("loggedInCustomer", customer.getEmail());
			System.out.println("CUSTOMER IS VALID");
			return true;
		} else {
			System.out.println("CUSTOMER IS NOT VALID");
			return false;
		}
	}

	@PostMapping("/createCustomer")
	public boolean createCustomer(@RequestBody String jsonDataDto) throws JsonMappingException, JsonProcessingException {
		//username, password, firstname, lastname, email
		
		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode jsonNode = objectMapper.readTree(jsonDataDto);
		
		String username = jsonNode.get("username").asText();
		String password = jsonNode.get("password").asText();
		String firstName = jsonNode.get("firstName").asText();
		String lastName = jsonNode.get("lastName").asText();
		String email = jsonNode.get("email").asText();
		
		System.out.println("firstName: " + firstName);
		if(customerService.createCustomer(username, password, firstName, lastName, email)) {
			return true;
		} else {
			return false;
		}
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
