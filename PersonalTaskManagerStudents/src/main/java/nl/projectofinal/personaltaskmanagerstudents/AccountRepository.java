package nl.projectofinal.personaltaskmanagerstudents;

import nl.projectofinal.personaltaskmanagerstudents.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    //define custom query methods when needed
    Optional<Account> findByEmail(String email);

}
