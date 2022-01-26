package com.webproject.derash;

import com.webproject.derash.entity.Station;
import com.webproject.derash.entity.User;
import com.webproject.derash.repository.StationRepository;
import com.webproject.derash.repository.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DerashApplication {
	
	@Autowired
	private  PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(DerashApplication.class, args);
	}
	@Bean
	public CommandLineRunner dataLoader(StationRepository repo) {
		return args -> {
			List<Station> stations= repo.findAll();
			if(stations.isEmpty()) {
			
			repo.save(new Station(1L,"4 kilo","abebawdegsew@email.com"));
			repo.save(new Station(2L,"5 kilo","dagimfikru@email.com"));
			repo.save(new Station(3L,"6 kilo","kidussintayehu60@email.com"));
			repo.save(new Station(4L,"piassa","seblina1224@gmail.com"));
			repo.save(new Station(5L,"bole","shewaregafenet@gmail.com"));
			}
		};
		

}
	@Bean
	public CommandLineRunner adminCreator(UserRepository repo) {
		return args -> {
			List<User> users= repo.findAll();
			if(users.isEmpty()) {
			String password =encoder.encode("12345678");
			repo.save(new User(1L,"degsew","degsew@gmail.com",password,password,"ADMIN"));
			}
		};
		

		

}
	
}
