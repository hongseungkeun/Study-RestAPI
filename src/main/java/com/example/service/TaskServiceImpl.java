package com.example.service;

import com.example.domain.Task;
import com.example.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public ResponseEntity<Task> readTask(Long id) {
        return taskRepository.readTask(id);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.createTask(task);
    }

    @Override
    public ResponseEntity<Task> updateTask(Long id, Task task) {
        return taskRepository.updateTask(id, task);
    }

    @Override
    public ResponseEntity<Task> deleteTask(Long id) {
        return taskRepository.deleteTask(id);
    }
}
