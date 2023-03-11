package com.ics499.clothingstore.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class User {
	
	@Id
	@GeneratedValue
	private long userId;

	public long getUserId() {
		return userId;
	}
}
