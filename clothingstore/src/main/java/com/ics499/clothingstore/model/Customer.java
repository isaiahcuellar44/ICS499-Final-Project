package com.ics499.clothingstore.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer extends User {

	@GeneratedValue
	private long customerId;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	private Rewards rewards; 

	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String phoneNumber;
	private Date dateAccountCreated;
	private String email;
	private String password;

	public Customer(String firstName, String lastName, String address, String city, String state, String phoneNumber,
			Date dateAccountCreated, String email) {
		super(new ShoppingCart());
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.dateAccountCreated = dateAccountCreated;
		this.email = email;
	}

	public Customer() {
		super(new ShoppingCart());
	}

	public long getId() {
		return this.customerId;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getDateAccountCreated() {
		return dateAccountCreated;
	}

	public void setDateAccountCreated(Date dateAccountCreated) {
		this.dateAccountCreated = dateAccountCreated;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

//	public Rewards getRewards() {   // took these out, customer rewards should be independent of customer object -- TomW
//		return rewards;
//	}
//
//	public void setRewards(Rewards rewards) {
//		this.rewards = rewards;
//	}

	// @Override
	// public String toString() {
	// return "Account [address=" + address + ", city=" + city + ", state=" + state
	// + ", phoneNumber=" + phoneNumber
	// + ", dateAccountCreated=" + dateAccountCreated + ", transactionHistory=" +
	// transactionHistory + "]";
	// }

}
