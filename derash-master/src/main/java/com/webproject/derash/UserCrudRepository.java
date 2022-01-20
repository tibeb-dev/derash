package com.webproject.derash;

import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<RegisterPage, String> {

	public RegisterPage findByEmail(String email);
}
