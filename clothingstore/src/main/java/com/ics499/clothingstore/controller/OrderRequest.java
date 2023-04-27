package com.ics499.clothingstore.controller;

import java.util.List;

import com.ics499.clothingstore.model.Product;

public class OrderRequest {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
