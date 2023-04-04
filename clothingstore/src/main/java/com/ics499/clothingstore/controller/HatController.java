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

import com.ics499.clothingstore.model.Hat;
import com.ics499.clothingstore.repository.HatRepository;

@RestController
@RequestMapping("/hat")
@CrossOrigin(origins = "http://localhost:4200")
public class HatController {

	@Autowired
	HatRepository hatRepository;
//	@Autowired
//	private ProductServiceImp prodServ;

	@GetMapping("/test")
	public String test() {

		// Hat hatToAdd = new Hat(10, 4, "Cool hat", "adidas", "green", "10", "yes",
		// HatType.Bucket);
		// prodServ.addHat(10, 4, "Cool hat", "adidas", "green", "10", "yes",
		// HatType.Bucket);
		return "Hat Controller";
	}

	@PostMapping("/save")
	public Hat saveHat(@RequestBody Hat hat) {
		return hatRepository.save(hat);
	}

	@PostMapping("/saveMany")
	public List<Hat> saveManyHats(@RequestBody List<Hat> hats) {
		return hatRepository.saveAll(hats);
	}

	@GetMapping("/all")
	public List<Hat> list() {
		return hatRepository.findAll();
	}

	@GetMapping("{id}")
	public Hat get(@PathVariable long id) {
		return hatRepository.getReferenceById(id);
	}

	@PostMapping("/add")
	public Hat create(@RequestBody final Hat hat) {
		return hatRepository.saveAndFlush(hat);
	}
	
	@GetMapping("/getAll")
	public List<Hat> getAll() {
		return hatRepository.findAll();
	}
}
