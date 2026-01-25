package com.example.springbootwebh2.service;
import java.util.List;

import com.example.springbootwebh2.model.User;

public interface UserService {
    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);
}
