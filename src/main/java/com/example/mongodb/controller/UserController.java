package com.example.mongodb.controller;

import com.example.mongodb.dto.UserDTO;
import com.example.mongodb.entity.User;
import com.example.mongodb.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody UserDTO userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/name/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @GetMapping("/query")
    public User queryUserByName(@RequestParam String name) {
        return userService.findByName(name);
    }

    @GetMapping("/search")
    public ResponseEntity<User> searchUserByName(@RequestParam String name) {
        User user = userService.findByName(name);
        if (user == null) {
            // 如果用户不存在，可以返回404 Not Found状态码
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    @GetMapping("/match")
    public List<User> getUsersByNameContaining(@RequestParam String name) {
        return userService.findUsersByNameContaining(name);
    }
}