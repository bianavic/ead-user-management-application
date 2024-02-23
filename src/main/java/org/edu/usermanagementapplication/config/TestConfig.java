package org.edu.usermanagementapplication.config;

import lombok.RequiredArgsConstructor;
import org.edu.usermanagementapplication.entities.User;
import org.edu.usermanagementapplication.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;

import java.util.Arrays;

@RequiredArgsConstructor
public class TestConfig implements CommandLineRunner {

    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        userRepository.saveAll(Arrays.asList(u1, u2));
    }

}