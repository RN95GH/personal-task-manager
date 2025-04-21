package nl.projectofinal.personaltaskmanagerstudents.service;

import nl.projectofinal.personaltaskmanagerstudents.UserDTO;
import nl.projectofinal.personaltaskmanagerstudents.entity.User;
import nl.projectofinal.personaltaskmanagerstudents.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

        private final UserRepository userRepository;

        @Autowired
        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public User createUser(User user) {
        //null check
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            throw new IllegalArgumentException("User data is incomplete");
        }

        //check username already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new IllegalStateException("Username already exists");
        }

        return userRepository.save(user);
    }

        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        public User getUserByUsername(String username) {
            return userRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        }

    public UserDTO convertToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());

        if (user.getAccount() != null) {
            dto.setName(user.getAccount().getName());
        }

        return dto;
    }

}

// write business logic using repository.


