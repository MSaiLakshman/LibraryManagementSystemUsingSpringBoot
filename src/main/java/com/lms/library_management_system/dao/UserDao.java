package com.lms.library_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lms.library_management_system.entity.User;
import com.lms.library_management_system.repository.UserRepository;

@Repository
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int userId, User user) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            user.setUserId(userId);
            userRepository.save(user);
            return optional.get();
        }
        return null;
    }

    public User findByUserId(int userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public User deleteUser(int userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            userRepository.delete(optional.get());
            return optional.get();
        }
        return null;
    }

    public List<User> fetchAllUsers() {
        return userRepository.findAll();
    }
}
