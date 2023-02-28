package com.ics499.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ics499.clothingstore.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
