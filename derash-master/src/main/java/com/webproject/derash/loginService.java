package com.webproject.derash;


import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 
 
 
@Service
public class loginService {
@Autowired
private LoginRepository repo;
  
  public LoginPage login(String email, String password) {
  LoginPage user = repo.findByUsernameAndPassword(email, password);
   return user;
  }
 
}