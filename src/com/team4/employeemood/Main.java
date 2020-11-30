package com.team4.employeemood;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

//        MoodData md = new MoodData();
//        md.loadMoodDataFromFile("MoodSampleFile.csv");
//        md.displayMoodData();


        FileImporter fileImporter = new FileImporter();

        fileImporter.loadDataFromFile("MoodSampleFile.csv", FileImporter.ImportTypeEnum.MOOD);
        fileImporter.loadDataFromFile("ProjectSampleFile.csv", FileImporter.ImportTypeEnum.PROJECT);
        fileImporter.loadDataFromFile("UsersSampleFile.csv", FileImporter.ImportTypeEnum.USER);
        fileImporter.displayRecordsFromRawDataMap();


    }
}
