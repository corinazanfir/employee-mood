package com.team4.employeemood;

import com.team4.employeemood.Mood;
import com.team4.employeemood.Project;
import com.team4.employeemood.User;

import java.util.ArrayList;
import java.util.List;

public class UserData {

    public static List<User> userList = new ArrayList<>();

    public void displayList() {
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
