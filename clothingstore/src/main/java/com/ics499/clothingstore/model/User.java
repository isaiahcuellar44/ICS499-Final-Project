package com.ics499.clothingstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class User {
	
	@Id
	@GeneratedValue
	private long userId;
	
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
	private ShoppingCart userCart;
    
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Transaction> transactions;
    
	public User(ShoppingCart shoppingCart) {
		super();
		this.userCart = shoppingCart;
	}
    
	public User() {
		super();
		this.userCart = new ShoppingCart();
	}

	public long getUserId() {
		return userId;
	}

	public ShoppingCart getUserCart() {
		return userCart;
	}

	public void setUserCart(ShoppingCart userCart) {
		this.userCart = userCart;
	}
}
