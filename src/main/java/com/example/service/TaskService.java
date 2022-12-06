package com.example.service;

import com.example.domain.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();
    Task readTask(Long id);
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    Task deleteTask(Long id);
}
