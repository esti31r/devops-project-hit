package final_project;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    /**
     * constructor-based Dependency Injection (DI)
     * @param userRepository
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all users
     * @return list of users
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Saves a new user
     * @param user User entity to save
     * @return saved user if successful
     */
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    /**
     * Update a possibly existing user
     * @param id ID of the user to update
     * @param userDetails all details from JSON in the request body
     * @return updates user Entity
     * @throws RuntimeException if id is not in database
     */
    public User updateUser(Long id, User userDetails) {
       User user = userRepository.findById(id).orElseThrow(()->
               new RuntimeException("User not found"));
       user.setJobName(userDetails.getJobName());
       user.setStatus(userDetails.getStatus());
       user.setCreatedAt(userDetails.getCreatedAt());
       user.setUpdatedAt(userDetails.getUpdatedAt());

       return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
