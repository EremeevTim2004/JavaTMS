package com.test_task.taskmanagementsystem.repository;

import com.test_task.taskmanagementsystem.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<Task> findById(Long id);

    List<Task> findByAuthorId(Long authorId);

    List<Task> findByAssigneeId(Long assigneeId);

    List<Task> findByAuthorIdAndAssigneeId(Long authorId, Long assigneeId);
}
