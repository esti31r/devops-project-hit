package final_project;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDateTime;
import java.util.Date;

@Configuration
public class DatabaseSeeder {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseSeeder.class);
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, CICDJobRepository ciCdJobRepository) {
        return args -> {
            logger.info("Seeding database with initial data...");

            // Create and save users
            User user1 = new User("Esti Rabino", "esti.rabino@example.com", "123-456-7890", "123 Main St, City, Country", passwordEncoder.encode("password123"));
            User user2 = new User("Tomer Idan", "tomer.idan@example.com", "123-456-7890", "456 Another St, City, Country", passwordEncoder.encode("password123"));
            User user3 = new User("Gal Valter", "gal.valter@example.com", "123-456-7890", "789 Third Ave, City, Country", passwordEncoder.encode("password123"));

            userRepository.save(user1);
            logger.info("Created User: {}", user1);

            userRepository.save(user2);
            logger.info("Created User: {}", user2);

            userRepository.save(user3);
            logger.info("Created User: {}", user3);

            // Create and save CI/CD jobs
            CICDJob job1 = new CICDJob("Job 1", "Pending", "Build");
            CICDJob job2 = new CICDJob("Job 2", "Running", "Test");
            CICDJob job3 = new CICDJob("Job 3", "Failed", "Deploy");

            ciCdJobRepository.save(job1);
            logger.info("Created CICD Job: {}", job1);

            ciCdJobRepository.save(job2);
            logger.info("Created CICD Job: {}", job2);

            ciCdJobRepository.save(job3);
            logger.info("Created CICD Job: {}", job3);

            logger.info("Database seeding completed.");
        };
    }
}
