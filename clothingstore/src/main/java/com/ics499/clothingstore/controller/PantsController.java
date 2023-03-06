package com.ics499.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ics499.clothingstore.model.Pants;
import com.ics499.clothingstore.repository.PantsRepository;

@RestController
public class PantsController {
	
	@Autowired
	PantsRepository pantsRepository;
	
	@GetMapping("/pants")
	public String test() {
		return "Pants Controller";
	}
	
	@PostMapping("/savePants")
	public Pants savePants(@RequestBody Pants pants) {
		return pantsRepository.save(pants);
	}
	
	@PostMapping("/saveManyPants")
	public List<Pants> saveManyPants(@RequestBody List<Pants> pants) {
		return pantsRepository.saveAll(pants);
	}
}
