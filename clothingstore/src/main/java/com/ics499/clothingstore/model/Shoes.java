package com.ics499.clothingstore.model;

import javax.persistence.Entity;

@Entity
public class Shoes extends Product {

	public enum ShoesType {
		sneakers, dress, sandles, boots, slippers
	}

	private ShoesType type;

	public Shoes(float price, int stock, String description, String brand, String color, String size, String fit,
			ShoesType type, String image_source) {
		super(price, stock, description, brand, color, size, fit, image_source);
		this.type = type;
	}

	public Shoes() {

	}

	public ShoesType getType() {
		return type;
	}

	public void setType(ShoesType type) {
		this.type = type;
	}
}
