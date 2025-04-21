package nl.projectofinal.personaltaskmanagerstudents.entity;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
//import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
import nl.projectofinal.personaltaskmanagerstudents.entity.User;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        private String name;

        @Email
        @NotBlank
        private String email;

        @JsonIgnore
        @OneToOne
        @JoinColumn(name = "user_id")
        private User user;

        // Getters & Setters
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }

        public User getUser() {
            return user;
        }
        public void setUser(User user) {
            this.user = user;
        }
}
