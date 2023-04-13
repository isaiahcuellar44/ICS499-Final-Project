package com.ics499.clothingstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Product {

	@Id
	@GeneratedValue
	private long productId;

	private float price;
	private int stock;
	private String Description;
	private String brand;
	private String color;
	private String size;
	private String fit;

	public Product(float price, int stock, String description, String brand, String color, String size, String fit) {
		super();
		this.price = price;
		this.stock = stock;
		Description = description;
		this.brand = brand;
		this.color = color;
		this.size = size;
		this.fit = fit;
	}

	public Product() { // not needed, threw error -- TomW

	}

	public long getProductId() { // added getter for ProductId -- TomW 3/17
		return productId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getFit() {
		return fit;
	}

	public void setFit(String fit) {
		this.fit = fit;
	}

	@Override
	public String toString() {
		return "Product [price=" + price + ", stock=" + stock + ", Description=" + Description + ", brand=" + brand
				+ ", color=" + color + ", size=" + size + ", fit=" + fit + "]";
	}

}
