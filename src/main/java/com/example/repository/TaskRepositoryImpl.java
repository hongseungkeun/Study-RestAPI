package com.example.repository;

import com.example.domain.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TaskRepositoryImpl implements TaskRepository{
    private static final Map<Long, Task> tasks = new ConcurrentHashMap<>();

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public ResponseEntity<Task> readTask(Long id) {
        if(!tasks.containsKey(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tasks.get(id), HttpStatus.OK);
    }

    @Override
    public Task createTask(Task task) {
        Task newTask = Task.CreateNewTask().id(Generated.incrementId()).title(task.getTitle()).build();
        tasks.put(newTask.getId(), newTask);
        return newTask;
    }

    @Override
    public ResponseEntity<Task> updateTask(Long id, Task task) {
        if(!tasks.containsKey(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        task.setId(id);
        tasks.put(task.getId(),task);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Task> deleteTask(Long id) {
        if(!tasks.containsKey(id)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Task task = tasks.get(id);
        tasks.remove(id);
        return new ResponseEntity<>(task, HttpStatus.NO_CONTENT);
    }
}
