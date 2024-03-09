package com.example.Forum.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Get all users
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // Get a single user by id
    @GetMapping(path = "{userId}")
    public User getUser(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    // Create a new user
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    // Update an existing user
    @PutMapping(path = "{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User newUser) {
        return userService.updateUser(userId, newUser);
    }

    // Delete a user by id
    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
