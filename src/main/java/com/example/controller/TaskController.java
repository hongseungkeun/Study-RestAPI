package com.example.controller;

import com.example.domain.Task;
import com.example.service.TaskService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @ApiOperation(value = "ToDo 목록 얻기")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Task> read(){
        return taskService.findAll();
    }

    @ApiOperation(value = "ToDo 상세 조회하기")
    @GetMapping("/{id}")
    public ResponseEntity<Task> read(@PathVariable Long id){
        return taskService.readTask(id);
    }

    @ApiOperation(value = "ToDo 생성하기 ")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @ApiOperation(value = "ToDo 제목 수정하기")
    @RequestMapping(value = "/{id}", method = {RequestMethod.PATCH, RequestMethod.PUT})
    public ResponseEntity<Task> update(@PathVariable Long id, @RequestBody Task task){
        return taskService.updateTask(id, task);
    }

    @ApiOperation(value = "ToDo 삭제하기")
    @DeleteMapping("/{id}")
    public ResponseEntity<Task> delete(@PathVariable Long id){
        return taskService.deleteTask(id);
    }
}
