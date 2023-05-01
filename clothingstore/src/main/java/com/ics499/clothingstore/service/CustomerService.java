package com.ics499.clothingstore.service;

/**
 * Customer Service Interface to setup implementation of service
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */
public interface CustomerService {
	boolean isValid(String username, String password);

	String createCustomer(String firstName, String lastName, String address, String city, String state,
			String phoneNumber, String email);

	boolean createCustomer(String username, String password, String firstname, String lastname, String email);
}
