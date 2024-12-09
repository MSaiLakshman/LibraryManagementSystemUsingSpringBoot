package com.lms.library_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lms.library_management_system.dto.UserDto;
import com.lms.library_management_system.entity.User;
import com.lms.library_management_system.service.UserService;
import com.lms.library_management_system.util.ResponseStructure;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/{addressID}")
    public ResponseEntity<ResponseStructure<User>> saveUser(
            @RequestBody UserDto userDto, @PathVariable int addressID) {
        return userService.saveUser(userDto, addressID);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseStructure<User>> findByUserId(@PathVariable int userId) {
        return userService.findByUserId(userId);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<ResponseStructure<User>> updateUser(
            @PathVariable int userId, @RequestBody UserDto userDto) {
        return userService.updateUser(userId, userDto);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<ResponseStructure<String>> deleteUser(@PathVariable int userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping
    public ResponseEntity<ResponseStructure<List<User>>> getAllUsers() {
        return userService.getAllUsers();
    }
}
