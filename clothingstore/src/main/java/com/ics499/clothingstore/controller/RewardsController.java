package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Rewards;
import com.ics499.clothingstore.repository.RewardsRepository;

@RestController
@RequestMapping("rewards")
@CrossOrigin(origins = "http://localhost:4200")
public class RewardsController {
	
	@Autowired
	RewardsRepository rewardsRepository;
	
	@GetMapping("/test")
	public String test() {
		return "Rewards Controller";
	}
	
	@PostMapping("/save")
	public Rewards saveRewards(@RequestBody Rewards reward) {
		return rewardsRepository.save(reward);
	}
	
	@PostMapping("/saveMany")
	public List<Rewards> saveManyRewards(@RequestBody List<Rewards> rewards) {
		return rewardsRepository.saveAll(rewards);
	}
	
	@GetMapping("/all")
	public List<Rewards> list() {
		return rewardsRepository.findAll();
	}
	
	@GetMapping("{id}")
	public Rewards get(@PathVariable Long id) {
		return rewardsRepository.getReferenceById(id);
	}
	
	@PostMapping("/add")
	public Rewards create(@RequestBody final Rewards reward) {
		return rewardsRepository.saveAndFlush(reward);
	}
}
