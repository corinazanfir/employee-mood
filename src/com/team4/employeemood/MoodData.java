package com.team4.employeemood;

import com.team4.employeemood.exceptions.MoodConstructException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoodData {

    public static List<Mood> moodList = new ArrayList<>();

    public void loadMoodDataFromFile(String filePath) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                Mood mood = new Mood(line);
                MoodData.moodList.add(mood);

                //System.out.println(line); //kept for debugging

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (MoodConstructException e) {
            e.printStackTrace();
        }
    }

    public void displayMoodData() {
        for (Mood m : MoodData.moodList) {
            System.out.println(m);
        }
    }

}
