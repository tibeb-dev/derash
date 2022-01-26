package com.webproject.derash.entity;





import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity


     

public class User{
    

    

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true,nullable = false)
    @NotBlank(message = "Username is mandatory")
    @Size(min = 5, message = "User name must be at least 5 characters long")
    private String username;

 


    @Column(nullable = false, unique = true)
    @NotBlank(message = "email mustnot be empty")
    @Email( message = "invalid email",regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
    	    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = " Password is mandatory")
    @Size(min=8,message = "password should be at least 8 characters")
    private String password;

    @Column(nullable = false)
    @NotBlank(message = " confirm Password is mandatory")
    private String confirmpassword;

    private String role="USER";
    
    
   
    }

