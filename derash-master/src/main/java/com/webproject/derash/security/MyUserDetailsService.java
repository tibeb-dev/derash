package com.webproject.derash.security;

import com.webproject.derash.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.webproject.derash.entity.User;
 @Service
public class MyUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UserRepository userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user \n\n\n\n\n\n\n\n\n\n");
        }
         
        return new MyUserDetails(user);
    }
 
}
