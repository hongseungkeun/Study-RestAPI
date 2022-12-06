package com.example.repository;

import com.example.domain.Task;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();
    Task readTask(Long id);
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    Task deleteTask(Long id);
}
