package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ics499.clothingstore.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("SELECT c FROM Customer c WHERE c.firstName = ?1")
	Customer findByName(@Param("name") String name);

	@Query("SELECT c FROM Customer c WHERE c.email = ?1")
	Customer findByEmail(@Param("email") String email);

	@Query("SELECT c FROM Customer c WHERE c.username = ?1")
	Customer findByUsername(@Param("username") String username);
}
