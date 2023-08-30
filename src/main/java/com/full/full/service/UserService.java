package com.full.full.service;

import com.full.full.models.Task;
import com.full.full.models.User;

import java.util.List;


public interface UserService {
    User createUser(User newUser);
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
    void assignTaskToUser(Long taskId, Long userId);
    List<Task> getAssignedTasksForUser(Long userId);
    List<User> getAvailableUsers();
    List<User> getJoinedMembers();
    void joinChatroom(String username);
}
