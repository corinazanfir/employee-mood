package com.team4.employeemood;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {


        FileImporter fileImporter = new FileImporter();

        fileImporter.loadDataFromFile("MoodSampleFile.csv", FileImporter.ImportTypeEnum.MOOD);
        fileImporter.loadDataFromFile("MoodSampleFile2.csv", FileImporter.ImportTypeEnum.MOOD);
        fileImporter.loadDataFromFile("ProjectSampleFile.csv", FileImporter.ImportTypeEnum.PROJECT);
        fileImporter.loadDataFromFile("UsersSampleFile.csv", FileImporter.ImportTypeEnum.USER);
        fileImporter.displayRecordsFromRawDataMap();

        FileImporterValidator fileImporterValidator = new FileImporterValidator();
        fileImporterValidator.validateData(FileImporter.ImportTypeEnum.MOOD);


        MoodData md = new MoodData();
//        md.loadMoodDataFromFile("MoodSampleFile.csv");
        md.displayMoodData();



    }
}
