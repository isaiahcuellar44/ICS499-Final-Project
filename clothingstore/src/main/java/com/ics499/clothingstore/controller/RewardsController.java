package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Rewards;
import com.ics499.clothingstore.repository.RewardsRepository;

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
	
	@PostMapping("/saveManyRewards")
	public List<Rewards> saveManyRewards(@RequestBody List<Rewards> rewards) {
		return rewardsRepository.saveAll(rewards);
	}
}
