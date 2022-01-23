package com.webproject.derash.repository;

import com.webproject.derash.entity.User;

import org.hibernate.annotations.SourceType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepo;
    @Test
    void testFindByUsername() {
        User user = userRepo.findByUsername("degsew");
        System.out.print(user.toString());
    }

}
