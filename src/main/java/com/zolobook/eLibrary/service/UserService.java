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
        return userRepository.findAll();
    }

    public String addUser(Users users) {
        userRepository.save(users);
        return "User Added Successfully";
    }

    public Users getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
