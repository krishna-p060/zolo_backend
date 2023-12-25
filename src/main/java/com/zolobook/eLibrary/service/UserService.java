package com.zolobook.eLibrary.service;

import com.zolobook.eLibrary.model.Users;
import com.zolobook.eLibrary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<Users> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving users.", e);
        }
    }

    public String addUser(Users users) {
        try {
            userRepository.save(users);
            return "User Added Successfully";
        } catch (Exception e) {
            throw new RuntimeException("Error adding user.", e);
        }
    }

    public Users getUserById(Integer id) {
        try {
            return userRepository.findById(id).orElse(null);
        } catch (Exception e) {
            throw new RuntimeException("Error retrieving user by ID.", e);
        }
    }

    // You can add more methods as needed
}