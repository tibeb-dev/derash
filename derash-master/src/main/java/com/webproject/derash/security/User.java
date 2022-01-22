package com.webproject.derash.security;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor


     

public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true,nullable = false)
    @NotBlank(message = "Username is mandatory")
    @Size(min = 5, message = "User name must be at least 5 characters long")
    private String username;

 


    @Column(nullable = false, unique = true)
    @NotBlank(message = "email mustnot be empty")
    @Email(message = "Email is not valid")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = " Password is mandatory")
    @Size(min=8,message = "password should be at least 8 characters")
    private String password;

    @Column(nullable = false)
    @NotBlank(message = " confirm password is mandatory")
    @Size(min=8,message = " confirm password should be at least 8 characters")
    private String confirmpassword;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
    @Override
    public boolean isAccountNonExpired() {
        
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
    
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        
        return true;
    }
    @Override
    public boolean isEnabled() {
    
        return true;
    }
    }

