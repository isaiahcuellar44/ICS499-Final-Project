package com.ics499.clothingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Hat extends Product {

	@GeneratedValue
	private long hatId = 0;

	public Hat(float price, int stock, String description, String brand, String color, String size, String fit) {
		super(price, stock, description, brand, color, size, fit);
		// TODO Auto-generated constructor stub
	}

	public Hat() {

	}

}
