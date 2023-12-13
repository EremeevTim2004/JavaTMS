package com.test_task.taskmanagementsystem.repository;

import com.test_task.taskmanagementsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    List<User> findByName(String name);
    Optional<User> findByEmail(String email);

    List<User> findByBirthday(Date birthday);
}
