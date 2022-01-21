package com.webproject.derash;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface  LoginRepository extends JpaRepository<LoginPage,Long> {
    LoginPage findByUsernameAndPassword(String email, String password);
    
}
