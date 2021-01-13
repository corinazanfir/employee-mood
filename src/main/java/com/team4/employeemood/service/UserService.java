package com.team4.employeemood.service;

import com.team4.employeemood.User;
import com.team4.employeemood.UserData;
import com.team4.employeemood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


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

    public List<User> listUsersByFirstName(String firstName) {
        return userRepository.findAllByFirstName(firstName);
    }

    public List<Long> getListOfUsersAssignedToProjectBetweenDates(Long projectId, Date startDate, Date endDate) {
        List<User> users = userRepository.findByProjectIdAndEmploymentDateBetween(projectId, startDate, endDate);
//        System.out.println(users);

        return users.stream()
                .map(User::getId)
                .collect(Collectors.toList());
    }
}
