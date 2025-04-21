package nl.projectofinal.personaltaskmanagerstudents.repository;

import nl.projectofinal.personaltaskmanagerstudents.entity.Task;
import nl.projectofinal.personaltaskmanagerstudents.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    //define custom query methods when needed
    List<Task> findByUser(User user);
    Optional<Task> findByIdAndUser(Long id, User user);
    List<Task> findByUserAndStatus(User user, Status status);

}
