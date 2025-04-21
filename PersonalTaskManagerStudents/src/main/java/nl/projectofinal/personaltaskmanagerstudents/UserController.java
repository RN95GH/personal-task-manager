package nl.projectofinal.personaltaskmanagerstudents.controllers;

import nl.projectofinal.personaltaskmanagerstudents.entity.User;
import nl.projectofinal.personaltaskmanagerstudents.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers().stream().map(userService::convertToDTO).collect(Collectors.toList());
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
//use Postman to test /users endpoints.