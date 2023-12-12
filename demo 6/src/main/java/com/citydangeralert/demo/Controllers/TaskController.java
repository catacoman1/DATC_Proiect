package com.citydangeralert.demo.Controllers;


import com.citydangeralert.demo.Entities.Task;
import com.citydangeralert.demo.Services.TaskService;
import com.citydangeralert.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return ResponseEntity.ok(savedTask);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable String id) {
        Task task = taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks(Task task)
    {
        List<Task>tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }
}
