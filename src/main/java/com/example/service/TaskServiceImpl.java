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

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task readTask(Long id) {
        return taskRepository.readTask(id);
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.createTask(task);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        return taskRepository.updateTask(id, task);
    }

    @Override
    public Task deleteTask(Long id) {
        return taskRepository.deleteTask(id);
    }
}
