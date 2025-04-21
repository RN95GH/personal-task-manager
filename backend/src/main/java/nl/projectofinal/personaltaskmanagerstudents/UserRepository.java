package nl.projectofinal.personaltaskmanagerstudents.repository;

import nl.projectofinal.personaltaskmanagerstudents.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //define custom query methods when needed
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

}

//extending JpaRepository, Spring Data JPA will auto-generate standard CRUD methods
