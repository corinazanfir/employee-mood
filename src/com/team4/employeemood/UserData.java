package com.team4.employeemood;

import com.team4.employeemood.Mood;
import com.team4.employeemood.Project;
import com.team4.employeemood.User;

import java.util.ArrayList;
import java.util.List;

public class UserData {

    public static List<User> userList = new ArrayList<>();

    public <T> void displayList(Iterable<T> inputList) {

        //workaround to display warning for classes that do not have a toString method defined
        try {
            System.out.println("\nDisplay data for the list - " + inputList.toString().substring(0, inputList.toString().indexOf("{")) + "]\n" + ("-").repeat(50));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("### WARNING ### You must define a toString method for the class " + inputList.toString().substring(0,inputList.toString().indexOf("@")) + "] that contains '{' character.");
            return;
        }

        for (Object element : inputList) {
            System.out.println(element);
        }
    }
}
