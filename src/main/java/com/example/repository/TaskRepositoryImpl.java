package com.example.repository;

import com.example.domain.Task;
import com.example.exception.TaskNotFoundException;
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
    public Task readTask(Long id) {
        validate(id);

        return tasks.get(id);
    }

    @Override
    public Task createTask(Task task) {
        Task newTask = Task.CreateNewTask().id(Generated.incrementId()).title(task.getTitle()).build();
        tasks.put(newTask.getId(), newTask);
        return newTask;
    }

    @Override
    public Task updateTask(Long id, Task task) {
        validate(id);

        task.setId(id);
        tasks.put(task.getId(),task);
        return task;
    }

    @Override
    public Task deleteTask(Long id) {
        validate(id);

        Task task = tasks.get(id);
        tasks.remove(id);
        return task;
    }

    public void validate(Long id){
        if(!tasks.containsKey(id)){
            throw new TaskNotFoundException("Id not found");
        }
    }
}
