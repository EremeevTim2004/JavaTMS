package com.test_task.taskmanagementsystem.service;

import com.test_task.taskmanagementsystem.model.Comment;
import com.test_task.taskmanagementsystem.model.Task;
import com.test_task.taskmanagementsystem.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Optional<Comment> getById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    public List<Comment> getByTaskId(Task task) {
        return commentRepository.findByTask(task);
    }

    public Comment createComment(Long taskId, Comment comment) {
        // Logic
    }

    public Comment updateComment(Long commentId, Comment updatedComment) {
        Optional<Comment> existingComment = commentRepository.findById(commentId);
        if(existingComment.isPresent()) {
            Comment currentComment = existingComment.get();
            currentComment.setText(updatedComment.getText());
            return commentRepository.save(currentComment);
        } else {
            return null;
        }
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
