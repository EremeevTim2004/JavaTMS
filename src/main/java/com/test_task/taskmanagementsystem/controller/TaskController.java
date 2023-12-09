package com.test_task.taskmanagementsystem.controller;

import com.test_task.taskmanagementsystem.model.Task;
import com.test_task.taskmanagementsystem.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<Task>> getTasksByAuthor(@PathVariable Long authorId) {
        // Получите пользователя по ID и передайте его в сервис
        // ...
        List<Task> tasks = taskService.getTasksByAuthor(author);
        return ResponseEntity.ok(tasks);
    }

    // Аналогичные методы для других эндпоинтов
    // ...

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }
}

