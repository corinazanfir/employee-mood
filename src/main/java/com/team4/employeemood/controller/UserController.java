package com.team4.employeemood.controller;

import com.team4.employeemood.model.User;
import com.team4.employeemood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
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

    @GetMapping("/login")
    public String getMoodForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session) {
        session.setAttribute("loggedUser", user);
        System.out.println(user + " has logged in");
        return "redirect:/";
    }
}
