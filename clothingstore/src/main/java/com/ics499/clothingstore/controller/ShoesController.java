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

import com.ics499.clothingstore.model.Shoes;
import com.ics499.clothingstore.repository.ShoesRepository;

/**
 * Shoes Controller, used to send information to Angular Front end.
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */

@RestController
@RequestMapping("/shoes")
@CrossOrigin(origins = "http://localhost:4200")
public class ShoesController {

	@Autowired
	ShoesRepository shoesRepository;

	@GetMapping("/shoes")
	public String test() {
		return "Shoes Controller";
	}

	@PostMapping("/save")
	public Shoes saveShoes(@RequestBody Shoes shoes) {
		return shoesRepository.save(shoes);
	}

	@PostMapping("/saveMany")
	public List<Shoes> saveManyShoes(@RequestBody List<Shoes> shoes) {
		return shoesRepository.saveAll(shoes);
	}

	@GetMapping("/getAll")
	public List<Shoes> getAll() {
		return shoesRepository.findAll();
	}

	@GetMapping("/getById/{id}")
	public Shoes getById(@PathVariable("id") Long id) {
		return shoesRepository.findByProductId(id);
	}
}
