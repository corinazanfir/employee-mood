package com.team4.employeemood;

import com.team4.employeemood.exceptions.PatternNotMatchingException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MoodData {

    public static List<Mood> moodList = new ArrayList<>();
    public static List<User> userList = new ArrayList<>();        //temporary solution to keep a list of loaded instances from file
    public static List<Project> projectList = new ArrayList<>();  //temporary solution to keep a list of loaded instances from file

    public <T> void displayList(Iterable<T> inputList) {

        System.out.println("\nDisplay data for the list - " + inputList.toString().substring(0,inputList.toString().indexOf("{")) + "]\n" + ("-").repeat(50));
        for (Object element : inputList) {
            System.out.println(element);
        }
    }

}
