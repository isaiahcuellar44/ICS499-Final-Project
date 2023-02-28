package com.ics499.clothingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Shoes extends Product {
	
	@GeneratedValue
	private long shoesId = 0;

	public Shoes(float price, int stock, String description, String brand, String color, String size, String fit) {
		super(price, stock, description, brand, color, size, fit);
		// TODO Auto-generated constructor stub
	}

	public Shoes() {

	}
}
