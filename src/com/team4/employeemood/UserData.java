package com.team4.employeemood;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    public static List<User> userList = new ArrayList<>();

    public <T> void displayList(Iterable<T> inputList) {

        System.out.println("\nDisplay data for the list - " + inputList.toString().substring(0,inputList.toString().indexOf("{")) + "]\n" + ("-").repeat(50));
        for (Object element : inputList) {
            System.out.println(element);
        }
    }
}
