package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics499.clothingstore.model.Guest;

public interface GuestRepository extends JpaRepository<Guest, Long>{

}
