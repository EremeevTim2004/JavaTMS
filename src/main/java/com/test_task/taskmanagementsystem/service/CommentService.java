package com.test_task.taskmanagementsystem.service;

import com.test_task.taskmanagementsystem.model.Comment;
import com.test_task.taskmanagementsystem.model.Task;
import com.test_task.taskmanagementsystem.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getCommentsByTask(Task task) {
        return commentRepository.findByTask(task);
    }

    public Comment createComment(Comment comment) {
        // Добавьте логику для создания комментария
        return commentRepository.save(comment);
    }
}
