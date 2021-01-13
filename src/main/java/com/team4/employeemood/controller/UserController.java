package com.team4.employeemood.controller;

import com.team4.employeemood.User;
import com.team4.employeemood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/api/v1/users")
    @ResponseBody
    public List<User> getAllUsers() throws ParseException {


        return userService.listUsers();


    }
}
