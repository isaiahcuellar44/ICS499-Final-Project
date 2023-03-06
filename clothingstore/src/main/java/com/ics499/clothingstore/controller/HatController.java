package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Hat;
import com.ics499.clothingstore.repository.HatRepository;



@RestController
@RequestMapping("/hat")
public class HatController {

	@Autowired
	private HatRepository hatRepo;
	
	@GetMapping("/all")
	public List<Hat> list(){
		return hatRepo.findAll();
	}
	
	
	@GetMapping("{id}")
	public Hat get(@PathVariable long id) {
		return hatRepo.getReferenceById(id);
			}
	@PostMapping("/add")
	public Hat create(@RequestBody final Hat hat) {
		return hatRepo.saveAndFlush(hat);
	}
}
