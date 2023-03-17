package com.ics499.clothingstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Rewards {
	
	@Id
	@GeneratedValue
	private long rewardsId;
	private int currentPoints;
	private int redeemedPoints;
	private int accountLifespanPoints;
	
	
	/* This doesn't set up the table for rewards to relate to customer */
//	@OneToOne(mappedBy = "rewards", cascade = CascadeType.ALL)
//	private Customer customer;
	
	//@JoinColumn(name = "CustomerID")	
	
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "CustomerID")
//	private Customer customer;
	
	
	/**
	 * Not sure if this is better or not, but this creates a linking table between customer and rewards. 
	 * This at least looks more like what I am used to seeing. -- TomW 3/17
	 */	
//	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(
//			name = "CustomerRewards",
//			joinColumns = @JoinColumn(name = "rewardsId"),
//			inverseJoinColumns = @JoinColumn(name = "CustomerId"))
	
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerID")
	private Customer customer;
	
	public Rewards(int currentPoints, int redeemedPoints, int accountLifespanPoints) {
		this.currentPoints = currentPoints;
		this.redeemedPoints = redeemedPoints;
		this.accountLifespanPoints = accountLifespanPoints;
	}
	
	public Rewards() {
		
	}
	
	public int getCurrentPoints() {
		return currentPoints;
	}

	public void setCurrentPoints(int currentPoints) {
		this.currentPoints = currentPoints;
	}

	public int getRedeemedPoints() {
		return redeemedPoints;
	}

	public void setRedeemedPoints(int redeemedPoints) {
		this.redeemedPoints = redeemedPoints;
	}

	public int getAccountLifespanPoints() {
		return accountLifespanPoints;
	}

	public void setAccountLifespanPoints(int accountLifespanPoints) {
		this.accountLifespanPoints = accountLifespanPoints;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Rewards [currentPoints=" + currentPoints + ", redeemedPoints=" + redeemedPoints
				+ ", accountLifespanPoints=" + accountLifespanPoints + "]";
	}

}
