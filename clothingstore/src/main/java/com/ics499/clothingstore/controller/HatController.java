package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Hat;
import com.ics499.clothingstore.repository.HatRepository;

@RestController
public class HatController {
	
	@Autowired
	HatRepository hatRepository;
	
	@GetMapping("/hat")
	public String test() {
		return "Hat Controller";
	}
	
	@PostMapping("/saveHat")
	public Hat saveHat(@RequestBody Hat hat) {
		return hatRepository.save(hat);
	}
	
	@PostMapping("/saveManyHats")
	public List<Hat> saveManyHats(@RequestBody List<Hat> hats) {
		return hatRepository.saveAll(hats);
	}
}
