package com.ics499.clothingstore.model;

import javax.persistence.Entity;

@Entity
public class Pants extends Product {

	//@GeneratedValue
	//private long pantsId = 0;
	
	public Pants(float price, int stock, String description, String brand, String color, String size, String fit) {
		super(price, stock, description, brand, color, size, fit);
		// TODO Auto-generated constructor stub
	}
	
	public Pants() {
		
	}

}
