package com.test_task.taskmanagementsystem.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Entity
public class Task {
    public enum TaskStatus {IN_PROGRESS, COMPLETED, PENDING}

    public enum TaskPriority {HIGH, MEDIUM, LOW}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @Enumerated(EnumType.STRING)
    private TaskPriority priority;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @ManyToOne
    @JoinColumn(name = "assignee_id")
    private User assignee;
    private Date taskCreationData;
    private Date taskDeadlineData;
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Task() {
    }

    public Task(String title, String description, TaskStatus status, TaskPriority priority, User author, User assignee, Date creationDate, Date deadline) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.author = author;
        this.assignee = assignee;
        this.taskCreationData = creationDate;
        this.taskDeadlineData = deadline;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public User getAuthor() {
        return author;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Date getTaskCreationData() {
        return taskCreationData;
    }

    public Date getTaskDeadlineData() {
        return taskDeadlineData;
    }

    public void setTaskDeadlineData(Date deadline) {
        this.taskDeadlineData = deadline;
    }
}
