package nl.projectofinal.personaltaskmanagerstudents.repository;

import nl.projectofinal.personaltaskmanagerstudents.entity.Notification;
import nl.projectofinal.personaltaskmanagerstudents.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    //define custom query methods when needed
    List<Notification> findByUserAndRead(User user, boolean read);
    Optional<Notification> findByIdAndUser(Long id, User user);

}
