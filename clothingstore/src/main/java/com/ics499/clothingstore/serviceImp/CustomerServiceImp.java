package com.ics499.clothingstore.serviceImp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ics499.clothingstore.model.Customer;
import com.ics499.clothingstore.repository.CustomerRepository;
import com.ics499.clothingstore.service.CustomerService;

/**
 * Customer Service Implementation. Works with Controller to change, update, and
 * return data to the front end.
 * 
 * @author Dylan Skokan - Isaiah Cuellar - Tom Waterman - Justin Pham - Kyle
 *         McClernon
 *
 */
@SpringBootApplication
public class CustomerServiceImp implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean isValid(String username, String password) {

		Customer foundCustomer = customerRepository.findByUsername(username);
		String hashedPassword = null;
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");

			m.update(password.getBytes());
			byte[] bytes = m.digest();

			StringBuilder s = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			hashedPassword = s.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		if (foundCustomer == null) {
			System.out.println("Customer does not exist");
			return false;
		}

		if (foundCustomer.getUsername().equals(username) && foundCustomer.getPassword().equals(hashedPassword)) {
			return true;
		} else {
			return false;
		}
	}

	public String createCustomer(String firstName, String lastName, String address, String city, String state,
			String phoneNumber, String email) {
		Date d1 = new Date();
		Customer newCustomer = new Customer();
		newCustomer.setDateAccountCreated(d1);
		customerRepository.save(newCustomer);
		return "Customer Created";
	}

	@Override
	public boolean createCustomer(String username, String password, String firstname, String lastname, String email) {
		try {
			if (customerRepository.findByUsername(username) != null) {
				return false;
			}

			Date d1 = new Date();
			Customer newCustomer = new Customer();
			newCustomer.setUsername(username);
			newCustomer.setPassword(password);
			newCustomer.setFirstName(firstname);
			newCustomer.setLastName(lastname);
			newCustomer.setEmail(email);
			newCustomer.setDateAccountCreated(d1);
			customerRepository.save(newCustomer);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean changePassword(Customer customer, String oldPassword, String newPassword) {
		if (oldPassword.equals(customer.getPassword())) {
			customer.setPassword(hashPassword(newPassword));
			return true;
		} else {
			return false;
		}
	}

	public String hashPassword(String password) {

		String hashedPassword = null;
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");

			m.update(password.getBytes());
			byte[] bytes = m.digest();

			StringBuilder s = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			hashedPassword = s.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hashedPassword;

	}

}
