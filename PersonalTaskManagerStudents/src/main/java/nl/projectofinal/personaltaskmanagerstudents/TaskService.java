package nl.projectofinal.personaltaskmanagerstudents.service;

import nl.projectofinal.personaltaskmanagerstudents.entity.Task;
import nl.projectofinal.personaltaskmanagerstudents.entity.User;
import nl.projectofinal.personaltaskmanagerstudents.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    //create service methods to read, update, delete tasks

    @Autowired
    private TaskRepository taskRepository;

    public Task save(Task task) {
        if (task == null || task.getTitle() == null || task.getDueDate() == null) {
            throw new IllegalArgumentException("Task must have title and due date");
        }
        return taskRepository.save(task);
    }

    public List<Task> findByUser(User user) {
        return taskRepository.findByUser(user);
    }

    public Optional<Task> findByIdAndUser(Long id, User user) {
        return taskRepository.findByIdAndUser(id, user);
    }

    public void delete(Task task) {
        taskRepository.delete(task);
    }
}

