package com.team4.employeemood.model;

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
