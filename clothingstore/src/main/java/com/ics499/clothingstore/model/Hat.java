package com.ics499.clothingstore.model;

import javax.persistence.Entity;

@Entity
public class Hat extends Product {

	public enum HatType {
		Baseball, Beanie, Bucket, Fedora, Top
	}

	private HatType type;

	public Hat(float price, int stock, String description, String brand, String color, String size, String fit,
			HatType type) {
		super(price, stock, description, brand, color, size, fit);
		this.type = type;
	}

	public Hat() {

	}

	public HatType getType() {
		return type;
	}

	public void setType(HatType type) {
		this.type = type;
	}
}
