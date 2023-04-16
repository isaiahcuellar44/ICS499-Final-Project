package com.ics499.clothingstore.model;

import javax.persistence.Entity;

@Entity
public class Guest extends User {

	// @GeneratedValue
	// private long sessionId;

	public Guest() {
		// super(new ShoppingCart());
	}

	@Override
	public String toString() {
		return "Guest: " + super.getUserId();
	}

}
