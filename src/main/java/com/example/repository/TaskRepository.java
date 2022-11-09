package com.example.repository;

import com.example.domain.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    ResponseEntity<Task> readTask(Long id);
    Task createTask(Task task);
    ResponseEntity<Task> updateTask(Long id, Task task);
    ResponseEntity<Task> deleteTask(Long id);
}
