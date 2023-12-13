package com.test_task.taskmanagementsystem.controller;

import com.test_task.taskmanagementsystem.model.Task;
import com.test_task.taskmanagementsystem.model.User;
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
    public ResponseEntity<List<Task>> getTasksByAuthor(@PathVariable User author) {
        List<Task> tasks = taskService.getByAuthorId(author);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/assignee/{assigneeId}")
    public ResponseEntity<List<Task>> getByAssignee(@PathVariable User assignee) {
        List<Task> tasks = taskService.getByAssignee(assignee);
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/author/{authorId} & /assignee/{assigneeId}")
    public ResponseEntity<List<Task>> getByAuthorAndAssignee(@PathVariable User author, @PathVariable User assignee) {
        List<Task> tasks = taskService.getByAuthorIdAndAssigneeId(author, assignee);
        return ResponseEntity.ok(tasks);
    }

    @PostMapping("/{taskId}")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) {
        Task task = taskService.updateTask(taskId, updatedTask);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTaskById(@RequestBody Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}

