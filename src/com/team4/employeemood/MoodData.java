package com.team4.employeemood;

import java.util.ArrayList;
import java.util.List;

public class MoodData {

    public static List<Mood> moodList = new ArrayList<>();
    public static List<User> userList = new ArrayList<>();        //temporary solution to keep a list of loaded instances from file
    public static List<Project> projectList = new ArrayList<>();  //temporary solution to keep a list of loaded instances from file

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

