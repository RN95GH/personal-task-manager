package nl.projectofinal.personaltaskmanagerstudents.controller;

import nl.projectofinal.personaltaskmanagerstudents.entity.Notification;
import nl.projectofinal.personaltaskmanagerstudents.entity.User;
import nl.projectofinal.personaltaskmanagerstudents.service.NotificationService;
import nl.projectofinal.personaltaskmanagerstudents.service.UserService;
import nl.projectofinal.personaltaskmanagerstudents.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationRepository notificationRepo;


    @GetMapping
    public ResponseEntity<List<Notification>> getNotifications(Authentication auth) {
        User user = userService.getUserByUsername(auth.getName());
        return ResponseEntity.ok(notificationService.getUserNotifications(user, false));
    }

    @PostMapping
    public ResponseEntity<Notification> createNotification(@RequestBody String message, Authentication auth) {
        User user = userService.getUserByUsername(auth.getName());
        Notification notification = notificationService.createNotification(user, message);
        return ResponseEntity.status(HttpStatus.CREATED).body(notification);
    }

    @PutMapping("/{id}/read")
    public ResponseEntity<?> markAsRead(@PathVariable Long id, Authentication auth) {
        User user = userService.getUserByUsername(auth.getName());
        Notification notification = notificationRepo.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Not found or unauthorized"));
        notification.setRead(true);
        notificationRepo.save(notification);
        return ResponseEntity.ok().build();
    }
}