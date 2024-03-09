package com.example.Forum.users;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User user1 = new User(
                    "john_doe",
                    "john.doe@example.com",
                    "password123"
            );
            User user2 = new User(
                    "jane_smith",
                    "jane.smith@example.com",
                    "securepassword"
            );
            repository.saveAll(List.of(user1,user2));
        };
    }
}
