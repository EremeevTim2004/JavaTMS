package com.test_task.taskmanagementsystem.repository;

import com.test_task.taskmanagementsystem.model.Task;
import com.test_task.taskmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByAuthor(User author);

    List<Task> findByAssignee(User assignee);

    Optional<Task> findByIdAndAuthor(Long id, User author);

    Optional<Task> findByIdAndAssignee(Long id, User assignee);
}
