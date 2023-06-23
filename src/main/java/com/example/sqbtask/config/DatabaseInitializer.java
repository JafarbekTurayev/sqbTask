package com.example.sqbtask.config;
import com.example.sqbtask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    @Autowired
    public DatabaseInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Code to add data to the database
        User user1 = new User("John Doe");
        userRepository.save(user1);

        User user2 = new User("Jane Smith");
        userRepository.save(user2);

        // More data insertion if needed
    }
}
