package com.ics499.clothingstore.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ics499.clothingstore.model.Hat;
import com.ics499.clothingstore.model.Hat.HatType;
import com.ics499.clothingstore.model.Pants;
import com.ics499.clothingstore.model.Pants.PantsType;
import com.ics499.clothingstore.model.Product;
import com.ics499.clothingstore.model.Shirt;
import com.ics499.clothingstore.model.Shirt.ShirtType;
import com.ics499.clothingstore.model.Shoes;
import com.ics499.clothingstore.model.Shoes.ShoesType;
import com.ics499.clothingstore.repository.HatRepository;
import com.ics499.clothingstore.repository.PantsRepository;
import com.ics499.clothingstore.repository.ProductRepository;
import com.ics499.clothingstore.repository.ShirtRepository;
import com.ics499.clothingstore.repository.ShoesRepository;

@SpringBootApplication
public class ProductServiceImp {

	@Autowired
	private ProductRepository<?> productRepository;
	@Autowired
	private HatRepository hatRepository;
	private PantsRepository pantsRepository;
	private ShirtRepository shirtRepository;
	private ShoesRepository shoeRepository;

	public void setStock(long productId, int amount) {
		Product productToUpdate = productRepository.findById(productId);
		productToUpdate.setStock(amount);
		productRepository.save(productToUpdate);// save function in repo may need to be changed.
	}

	public void addStock(long productId, int amount) {
		Product productToUpdate = productRepository.findById(productId);
		productToUpdate.setStock(productToUpdate.getStock() + amount);
		productRepository.save(productToUpdate);
	}

	public void addHat(float price, int stock, String description, String brand, String color, String size, String fit,
			HatType type) {
		Hat hatToAdd = new Hat(price, stock, description, brand, color, size, fit, type);
		productRepository.save(hatToAdd);
//		productRepository.addHat(price, description, brand, color, size, fit, type);
	}

	public void addPants(float price, int stock, String description, String brand, String color, String size,
			String fit, PantsType type, boolean pockets, boolean zipper, boolean beltloops) {
		Pants pantsToAdd = new Pants(price, stock, description, brand, color, size, fit, type, pockets, zipper,
				beltloops);
		productRepository.save(pantsToAdd);
	}

	public void addShirt(float price, int stock, String description, String brand, String color, String size,
			String fit, ShirtType type) {
		Shirt shirtToAdd = new Shirt(price, stock, description, brand, color, size, fit, type);
		productRepository.save(shirtToAdd);
	}

	public void addShoes(float price, int stock, String description, String brand, String color, String size,
			String fit, ShoesType type) {
		Shoes shoesToAdd = new Shoes(price, stock, description, brand, color, size, fit, type);
		productRepository.save(shoesToAdd);
	}
}
