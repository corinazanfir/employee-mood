package com.team4.employeemood;

import com.team4.employeemood.exceptions.MoodConstructException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MoodData {

    public static List<Mood> moodList = new ArrayList<>();

    public void readMoodDataFromFile(String filePath) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                Mood mood = new Mood(line);
                MoodData.moodList.add(mood);

                System.out.println(line);

                line = reader.readLine();
            }
            reader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        } catch (MoodConstructException e) {
            e.printStackTrace();
        }
    }


}
