package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics499.clothingstore.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}
