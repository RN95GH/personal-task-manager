package nl.projectofinal.personaltaskmanagerstudents.security;

import nl.projectofinal.personaltaskmanagerstudents.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UsersDetailsService implements UserDetailsService {

        @Autowired
        private UserRepository userRepo;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            var user = userRepo.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    user.getRoles() // roles implement GrantedAuthority
            );
        }
    }
