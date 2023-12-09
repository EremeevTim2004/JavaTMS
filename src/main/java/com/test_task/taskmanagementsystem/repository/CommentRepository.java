package com.test_task.taskmanagementsystem.repository;

import com.test_task.taskmanagementsystem.model.Comment;
import com.test_task.taskmanagementsystem.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByTask(Task task);
}
