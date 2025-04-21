package nl.projectofinal.personaltaskmanagerstudents.service;

import nl.projectofinal.personaltaskmanagerstudents.entity.Notification;
import nl.projectofinal.personaltaskmanagerstudents.entity.User;
import nl.projectofinal.personaltaskmanagerstudents.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {

        @Autowired
        private NotificationRepository notificationRepository;

        public List<Notification> getUserNotifications(User user, boolean read) {
        if (user == null) {
            throw new IllegalArgumentException("User is required");
        }
        return notificationRepository.findByUserAndRead(user, read);
    }

    public Notification createNotification(User user, String message) {
        if (user == null || message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("User and message are required");
        }

        public Notification createNotification(User user, String message) {
            Notification notification = new Notification();
            notification.setUser(user);
            notification.setNotification(message);
            notification.setRead(false);
            return notificationRepository.save(notification);
        }
        public Optional<Notification> findByIdAndUser(Long id, User user) {
            return notificationRepository.findByIdAndUser(id, user);
        }
    }
}
