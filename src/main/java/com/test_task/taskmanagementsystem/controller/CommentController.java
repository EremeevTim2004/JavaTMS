package com.test_task.taskmanagementsystem.controller;

import com.test_task.taskmanagementsystem.model.Comment;
import com.test_task.taskmanagementsystem.service.CommentService;
import com.test_task.taskmanagementsystem.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService commentService;
    private final TaskService taskService;

    public CommentController(CommentService commentService, TaskService taskService) {
        this.commentService = commentService;
        this.taskService = taskService;
    }

    @PostMapping("/commentId")
    public ResponseEntity<Comment> createComment(@PathVariable Long taskId, @RequestBody Comment comment) {
        Comment createdComment = commentService.createComment(taskId, comment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdComment);
    }

    @PutMapping("/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable Long commentId, @RequestBody Comment updatedComment) {
        Comment comment = commentService.updateComment(commentId, updatedComment);
        return ResponseEntity.ok(comment);
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.noContent().build();
    }
}
