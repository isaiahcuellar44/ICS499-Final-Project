package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Transaction;
import com.ics499.clothingstore.repository.TransactionRepository;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@GetMapping("/transaction")
	public String test() {
		return "Transaction Controller";
	}
	
	
	@GetMapping("/all")
	public List<Transaction> list() {
	
		
		return transactionRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Transaction get(@PathVariable Long id) {
		return transactionRepository.getReferenceById(id);
	}
	
	
	@PostMapping("/add")
	public Transaction create(@RequestBody final Transaction transaction) {
		return transactionRepository.saveAndFlush(transaction);
		
	}
}
