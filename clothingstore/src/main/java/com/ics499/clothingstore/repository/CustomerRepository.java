package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics499.clothingstore.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
