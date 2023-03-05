package com.ics499.clothingstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/user")
	public String test() {
		return "User Controller";
	}
	
	@GetMapping("/hat")
	public List<Hat> list(){
		return hatRepo.findAll();
	}
	
	@SuppressWarnings("deprecation")
	@GetMapping("{id}")
	public Hat get(@PathVariable long id) {
		return hatRepo.getOne(id);
			}
	@PostMapping("/add")
	public Hat create(@RequestBody final Hat hat) {
		return hatRepo.saveAndFlush(hat);
	}

}
