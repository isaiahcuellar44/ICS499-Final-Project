package com.ics499.clothingstore.serviceImp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ics499.clothingstore.model.Customer;
import com.ics499.clothingstore.repository.CustomerRepository;
import com.ics499.clothingstore.service.CustomerService;

@SpringBootApplication
public class CustomerServiceImp implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public boolean isValid(String username, String password) {

		Customer foundCustomer = customerRepository.findByEmail(username);
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

		if (foundCustomer.getEmail().equals(username) && foundCustomer.getPassword().equals(hashedPassword)) {
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

	public String createCustoemr(String firstName, String lastName, String address, String city, String state,
			String phoneNumber, String email) {
		Date d1 = new Date();
//		Customer newCustomer = new Customer(firstName, lastName, address, city, state, phoneNumber, d1, email);
		Customer newCustomer = new Customer();
		customerRepository.save(newCustomer);
		return "Customer Created";
	}

}
