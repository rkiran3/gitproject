package com.demo.sandbox.service;

import java.util.List;

import com.demo.sandbox.model.User;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
