package com.team4.employeemood;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {

        MoodData md = new MoodData();
        md.loadMoodDataFromFile("MoodSampleFile.csv");

        md.displayMoodData();

    }
}
