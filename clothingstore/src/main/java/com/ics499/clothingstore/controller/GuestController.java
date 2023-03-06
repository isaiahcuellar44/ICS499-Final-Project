package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Guest;
import com.ics499.clothingstore.repository.GuestRepository;

@RestController
public class GuestController {
	
	@Autowired
	GuestRepository guestRepository;
	
	@GetMapping("/guest")
	public String test() {
		return "Guest Controller";
	}
	
	@PostMapping("/saveGuest")
	public Guest saveGuest(@RequestBody Guest guest) {
		return guestRepository.save(guest);
	}
	
	@PostMapping("/saveManyGuests")
	public List<Guest> saveManyGuests(@RequestBody List<Guest> guests) {
		return guestRepository.saveAll(guests);
	}
}
