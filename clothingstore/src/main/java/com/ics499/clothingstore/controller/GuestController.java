package com.ics499.clothingstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.repository.GuestRepository;

@RestController
public class GuestController {
	
	@Autowired
	GuestRepository guestRepository;
	
	@GetMapping("/guest")
	public String test() {
		return "Guest Controller";
	}
}
