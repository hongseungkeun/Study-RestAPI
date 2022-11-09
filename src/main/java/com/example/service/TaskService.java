package com.example.service;

import com.example.domain.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    ResponseEntity<Task> readTask(Long id);
    Task createTask(Task task);
    ResponseEntity<Task> updateTask(Long id, Task task);
    ResponseEntity<Task> deleteTask(Long id);
}
