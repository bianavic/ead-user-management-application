package org.edu.usermanagementapplication.resources;

import org.edu.usermanagementapplication.entities.User;
import org.edu.usermanagementapplication.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserResourceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void getAll() {
        List<User> userList = userRepository.findAll();
        assertEquals(2, userList.size());
    }
}