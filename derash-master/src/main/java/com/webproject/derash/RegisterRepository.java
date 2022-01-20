package com.webproject.derash;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<RegisterPage, Long> {
	RegisterPage findByEmail(String email);


	
}
