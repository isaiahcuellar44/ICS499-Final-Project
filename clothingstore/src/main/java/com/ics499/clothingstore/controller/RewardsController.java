package com.ics499.clothingstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.repository.RewardsRepository;
import com.ics499.clothingstore.model.Rewards;

@RestController
public class RewardsController {
	
	@Autowired
	RewardsRepository rewardsRepository;
	
	@GetMapping("/rewards")
	public String test() {
		return "Rewards Controller";
	}
	
	@PostMapping("/saveRewards")
	public Rewards saveRewards(@RequestBody Rewards reward) {
		return rewardsRepository.save(reward);
	}
}
