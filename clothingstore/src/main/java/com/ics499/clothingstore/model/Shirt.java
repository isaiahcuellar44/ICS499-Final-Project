package com.ics499.clothingstore.model;

import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class Shirt extends Product {

	public enum ShirtType {
		tShirt, polo, dress, turtleneck, sweat, sleveless, vNeck
	}

	private ShirtType type;

	public Shirt(float price, int stock, String description, String brand, String color, String size, String fit,
			ShirtType type, String imageSource) {
		super(price, stock, description, brand, color, size, fit, imageSource);
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Shirt))
			return false;
		Shirt shirt = (Shirt) o;
		return Float.compare(shirt.price, price) == 0 && stock == shirt.stock
				&& Objects.equals(description, shirt.description) && Objects.equals(brand, shirt.brand)
				&& Objects.equals(color, shirt.color) && Objects.equals(size, shirt.size)
				&& Objects.equals(fit, shirt.fit) && type == shirt.type
				&& Objects.equals(image_source, shirt.image_source);
	}
}
