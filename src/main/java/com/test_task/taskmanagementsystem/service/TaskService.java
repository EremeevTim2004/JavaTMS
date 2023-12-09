package com.test_task.taskmanagementsystem.service;

import com.test_task.taskmanagementsystem.model.Task;
import com.test_task.taskmanagementsystem.model.User;
import com.test_task.taskmanagementsystem.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasksByAuthor(User author) {
        return taskRepository.findByAuthor(author);
    }

    public List<Task> getTasksByAssignee(User assignee) {
        return taskRepository.findByAssignee(assignee);
    }

    public Optional<Task> getTaskByIdAndAuthor(Long id, User author) {
        return taskRepository.findByIdAndAuthor(id, author);
    }

    public Optional<Task> getTaskByIdAndAssignee(Long id, User assignee) {
        return taskRepository.findByIdAndAssignee(id, assignee);
    }

    public Task createTask(Task task) {
        // Добавьте логику для создания задачи
        return taskRepository.save(task);
    }
}
