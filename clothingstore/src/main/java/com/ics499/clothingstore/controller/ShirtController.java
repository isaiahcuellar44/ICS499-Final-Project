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

import com.ics499.clothingstore.model.Shirt;
import com.ics499.clothingstore.repository.ShirtRepository;

/**
 * Shirt Controller, used to send information to Angular Front end.
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */

@RestController
@RequestMapping("/shirt")
@CrossOrigin(origins = "http://localhost:4200")
public class ShirtController {

	@Autowired
	ShirtRepository shirtRepository;

	@GetMapping("/test")
	public String test() {
		return "Shirt Controller";
	}

	@PostMapping("/save")
	public Shirt saveShirt(@RequestBody Shirt shirt) {
		return shirtRepository.save(shirt);
	}

	@PostMapping("/saveMany")
	public List<Shirt> saveManyShirts(@RequestBody List<Shirt> shirts) {
		return shirtRepository.saveAll(shirts);
	}

	@GetMapping("/getAll")
	public List<Shirt> getAll() {
		return shirtRepository.findAll();
	}

	@GetMapping("/getById/{id}")
	public Shirt getById(@PathVariable("id") Long id) {
		return shirtRepository.findByProductId(id);
	}
}
