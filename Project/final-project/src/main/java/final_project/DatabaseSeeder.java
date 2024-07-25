package final_project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@Configuration
public class DatabaseSeeder {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            logger.info("Seeding database with initial data...");

            User user1 = new User("John Doe", "john.doe@example.com", new Date(2000, 11, 1), new Date(2000, 11, 21),passwordEncoder.encode("password123"));
            User user2 = new User("Jane Doe", "jane.doe@example.com", new Date(2000, 11, 2), new Date(2000, 11, 21),passwordEncoder.encode("password123"));
            User user3 = new User("Jake Smith", "jake.smith@example.com", new Date(2000, 11, 3), new Date(2000, 11, 21),passwordEncoder.encode("password123"));

            userRepository.save(user1);
            logger.info("Created User: {}", user1);

            userRepository.save(user2);
            logger.info("Created User: {}", user2);

            userRepository.save(user3);
            logger.info("Created User: {}", user3);

            logger.info("Database seeding completed.");
        };
    }
}
