package com.webproject.derash.security;

import com.webproject.derash.entity.User;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

@Data
public class RegistrationForm {
   private String username;
   private String password;
   private String confirmpassword;
   private String email;

   public User toUser(PasswordEncoder encoder) {
       User user = new User();
       user.setUsername(this.username);
       user.setPassword(encoder.encode(this.password));
       user.setConfirmpassword(encoder.encode(this.confirmpassword));
       user.setEmail(this.email);
       return user;
   }
}

