package com.team4.employeemood.service;

import com.team4.employeemood.User;
import com.team4.employeemood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {

        return userRepository.save(user);

    }

    public List<User> listUsers() {

        return userRepository.findAll();

    }
}
