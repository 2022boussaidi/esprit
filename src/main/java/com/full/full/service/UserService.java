package com.full.full.service;

import com.full.full.models.User;

import java.util.List;


public interface UserService {
    User createUser(User newUser);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
}
