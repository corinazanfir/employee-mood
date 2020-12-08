package com.team4.employeemood;

import java.util.ArrayList;
import java.util.List;

public class MoodData {

    public static List<Mood> moodList = new ArrayList<>();

    public void displayList() {
        for (Mood mood : moodList) {
            System.out.println(mood);
        }
    }
}

