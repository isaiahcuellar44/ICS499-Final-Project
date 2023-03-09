package com.ics499.clothingstore.serviceImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ics499.clothingstore.model.Customer;
import com.ics499.clothingstore.service.CustomerService;

public class CustomerServiceImp implements CustomerService{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.isc499.clothingstore");
	EntityManager em = emf.createEntityManager();
	
	@Override
	public boolean isValid(String username, String password) {
		// TODO Auto-generated method stub
		
		int customer = em.createQuery("SELECT Customer from Customer customer where customer.id = ?id").getFirstResult();
		
		/*
		 * logic- 
		 * 
		 * if ((Customer.getPassword.equals(password)&&(customer.getUsername = username))
		 * return true;
		 */		
		return false;
	}

}
