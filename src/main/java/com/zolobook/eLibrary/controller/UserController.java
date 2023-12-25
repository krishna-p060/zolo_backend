package com.zolobook.eLibrary.controller;

import com.zolobook.eLibrary.model.Users;
import com.zolobook.eLibrary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public String addUser(@RequestBody Users users) {
        return userService.addUser(users);
    }


}
