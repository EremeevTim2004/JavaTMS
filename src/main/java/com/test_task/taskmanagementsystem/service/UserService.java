package com.test_task.taskmanagementsystem.service;

import com.test_task.taskmanagementsystem.model.User;
import com.test_task.taskmanagementsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getById(long userId) {
        return Optional.of(userRepository.getById(userId));
    }

    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getByBirthday(Date birthday) {
        return userRepository.findByBirthday(birthday);
    }
    public User createUser(User user) {
        // Добавить логику
        return userRepository.save(user);
    }

    public User updateUser(long userId, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(userId);
        if(existingUser.isPresent()) {
            User currentUser = existingUser.get();
            currentUser.setEmail(updatedUser.getEmail());
            currentUser.setPassword(updatedUser.getPassword());
            return userRepository.save(currentUser);
        } else {
            return null;
        }
    }

    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }
}
