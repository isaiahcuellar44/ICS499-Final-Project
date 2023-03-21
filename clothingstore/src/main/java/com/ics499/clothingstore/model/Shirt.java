package com.ics499.clothingstore.model;

import javax.persistence.Entity;

@Entity
public class Shirt extends Product {

	public enum ShirtType {
		tShirt, polo, dress, turtleneck, sweat, sleveless, vNeck
	}

	private ShirtType type;

	public Shirt(float price, int stock, String description, String brand, String color, String size, String fit,
			ShirtType type) {
		super(price, stock, description, brand, color, size, fit);
		this.type = type;
	}

	public Shirt() { 

	}

	public ShirtType getType() {
		return type;
	}

	public void setType(ShirtType type) {
		this.type = type;
	}

}
