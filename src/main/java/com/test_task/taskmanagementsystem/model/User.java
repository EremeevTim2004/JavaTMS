package com.test_task.taskmanagementsystem.model;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Date birthday;
    @Column(unique = true)
    private String email;
    private String password; // Hash
    @OneToMany(mappedBy = "author")
    private List<Task> authoredTasks;
    @OneToMany(mappedBy = "assignee")
    private List<Task> assignedTasks;

    public User() {
    }

    public User(String name, String email, String password, Date birthday) {
        this.name = name;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
