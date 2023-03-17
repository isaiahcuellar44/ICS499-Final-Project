package com.ics499.clothingstore.model;

import javax.persistence.Entity;

@Entity
public class Shoes extends Product {

	public enum ShoesType {
		sneakers, dress, sandles, boots, slippers
	}

	private ShoesType type;

	public Shoes(float price, int stock, String description, String brand, String color, String size, String fit,
			ShoesType type) {
		super(price, stock, description, brand, color, size, fit);
		this.type = type;
	}

//	public Shoes() { //-- Commented out, threw error because Product (super) constructor is undefined. -- TomW 3/17
//
//	}

	public ShoesType getType() {
		return type;
	}

	public void setType(ShoesType type) {
		this.type = type;
	}
}
