package com.test_task.taskmanagementsystem.service;

import com.test_task.taskmanagementsystem.model.Task;
import com.test_task.taskmanagementsystem.model.User;
import com.test_task.taskmanagementsystem.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Optional<Task> getById(Long taskId) {
        return taskRepository.findById(taskId);
    }

    public List<Task> getByAuthorId(User author) {
        return taskRepository.findByAuthorId(author.getId());
    }

    public List<Task> getByAssignee(User assignee) {
        return taskRepository.findByAssigneeId(assignee.getId());
    }

    public List<Task> getByAuthorIdAndAssigneeId(User author, User assignee) {
        return taskRepository.findByAuthorIdAndAssigneeId(author.getId(), assignee.getId());
    }
    public Task createTask(Task task) {
        // Добавть логику
        return taskRepository.save(task);
    }

    // fix & update
    public Task updateTask(Long taskId, Task updatedTask) {
        Optional<Task> existingTask = taskRepository.findById(taskId);
        if(existingTask.isPresent()) {
            Task currentTask = existingTask.get();
            currentTask.setTitle(updatedTask.getTitle());
            currentTask.setDescription(updatedTask.getDescription());
            currentTask.setAssignee(updatedTask.getAssignee());
            currentTask.setPriority(updatedTask.getPriority());
            currentTask.setStatus(updatedTask.getStatus());
            currentTask.setTaskDeadlineData(updatedTask.getTaskDeadlineData());
            return taskRepository.save(currentTask);
        } else {
            return null;
        }
    }

    public void deleteTask(Long commentId) {
        taskRepository.deleteById(commentId);
    }
}
