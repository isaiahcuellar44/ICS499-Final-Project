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

import com.ics499.clothingstore.model.Pants;
import com.ics499.clothingstore.repository.PantsRepository;

@RestController
@RequestMapping("/pants")
@CrossOrigin(origins = "http://localhost:4200")
public class PantsController {

	@Autowired
	PantsRepository pantsRepository;

	@GetMapping("/test")
	public String test() {
		return "Pants Controller";
	}

	@PostMapping("/save")
	public Pants savePants(@RequestBody Pants pants) {
		return pantsRepository.save(pants);
	}

	@PostMapping("/saveMany")
	public List<Pants> saveManyPants(@RequestBody List<Pants> pants) {
		return pantsRepository.saveAll(pants);
	}

	@GetMapping("/getAll")
	public List<Pants> getAll() {
		return pantsRepository.findAll();
	}

	@GetMapping("/getById/{id}")
	public Pants getById(@PathVariable("id") Long id) {
		return pantsRepository.findByProductId(id);
	}
}
