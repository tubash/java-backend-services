package com.example.backend.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repository;

    @Test
    void save() {
        //given
        UserEntity user = new UserEntity();
        user.setUsername("somename");
        repository.save(user);

        //when
        List<UserEntity> users = repository.findAll();

        //then
        assertEquals(1, users.size());
        assertEquals("somename", users.get(0).getUsername());

    }
}
