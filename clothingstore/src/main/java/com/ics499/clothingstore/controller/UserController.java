package com.ics499.clothingstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.repository.UserRepository;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/test")
	public String test() {
		return "User Controller";
	}
	
	
}
