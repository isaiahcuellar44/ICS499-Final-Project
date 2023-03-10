package com.ics499.clothingstore.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Customer extends User {
	
	@GeneratedValue
	private long customerId;
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String phoneNumber;
	private Date dateAccountCreated;
	
//	causes crash, can we have a column of custom objects such as a column ShoppingCart?
//	@ElementCollection
//	private List<Transaction> transactionHistory = new ArrayList<Transaction>();
//	private List<Rewards> customerRewards;

	public Customer(String firstName, String lastName, String address, String city, String state, String phoneNumber,
			Date dateAccountCreated) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.phoneNumber = phoneNumber;
		this.dateAccountCreated = dateAccountCreated;
	}
	
	private Customer() {}

	public void addTransactionToHistory() {
		//this.transactionHistory.add(t);
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

	
	
	//public List<Transaction> getTransactionHistory() {
		//return transactionHistory;
	//}

	//@Override
	//public String toString() {
	//	return "Account [address=" + address + ", city=" + city + ", state=" + state + ", phoneNumber=" + phoneNumber
	//			+ ", dateAccountCreated=" + dateAccountCreated + ", transactionHistory=" + transactionHistory + "]";
	//}

}
