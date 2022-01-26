package com.webproject.derash.repository;

import com.webproject.derash.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository 
extends JpaRepository<User, Long> {
   public User findByUsername(String username);
   public User findByEmail(String email);
}

