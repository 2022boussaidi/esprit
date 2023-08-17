package com.full.full.service;

import com.full.full.models.User;
import com.full.full.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private UserRepo userRepository;

    public UserServiceImpl(UserRepo userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User newUser) {
        return userRepository.save(newUser);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }

    @Override
    public User updateUser(Long id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPhone(updatedUser.getPhone());
        existingUser.setAccessLevel(updatedUser.getAccessLevel());


        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }
}
