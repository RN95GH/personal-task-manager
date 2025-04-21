package nl.projectofinal.personaltaskmanagerstudents.controller;

import nl.projectofinal.personaltaskmanagerstudents.entity.Task;
import nl.projectofinal.personaltaskmanagerstudents.entity.User;
import nl.projectofinal.personaltaskmanagerstudents.service.TaskService;
import nl.projectofinal.personaltaskmanagerstudents.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    //API endpoints for CRUD operations

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task, Authentication auth) {
        //Get username from the JWT Fetch User entity
        User user = userService.getUserByUsername(auth.getName());
        task.setUser(user); //Set task’s user
        Task saved = taskService.save(task); //Save task
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);

    }

    @GetMapping
    public ResponseEntity<List<Task>> getTasks(Authentication auth) {
        User user = userService.getUserByUsername(auth.getName());
        return ResponseEntity.ok(taskService.findByUser(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updates, Authentication auth) {
        User user = userService.getUserByUsername(auth.getName());
        Task task = taskService.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Task not found or not authorized"));

        task.setTitle(updates.getTitle());
        task.setDescription(updates.getDescription());
        task.setStatus(updates.getStatus());
        task.setPriority(updates.getPriority());
        task.setCategory(updates.getCategory());
        task.setDueDate(updates.getDueDate());
        task.setProgress(updates.getProgress());

        return ResponseEntity.ok(taskService.save(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id, Authentication auth) {
        User user = userService.getUserByUsername(auth.getName());
        Task task = taskService.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Task not found or not authorized"));

        taskService.delete(task);
        return ResponseEntity.noContent().build();
    }

}
