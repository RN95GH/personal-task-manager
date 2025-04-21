package nl.projectofinal.personaltaskmanagerstudents.entity;

import lombok.*;
import jakarta.persistence.*;
import nl.projectofinal.personaltaskmanagerstudents.NotificationStatus;
import nl.projectofinal.personaltaskmanagerstudents.entity.User;
import java.time.LocalDate;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long taskId;
    private String notification;
    private LocalDate date = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private NotificationStatus status;

    private boolean read;

    @ManyToOne
    private User user;

    //getters setters

}
