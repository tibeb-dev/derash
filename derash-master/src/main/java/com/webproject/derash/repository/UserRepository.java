package com.webproject.derash.repository;

import com.webproject.derash.entity.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository 
extends CrudRepository<User, Long> {
   public User findByUsername(String username);
   public User findByEmail(String email);
}

