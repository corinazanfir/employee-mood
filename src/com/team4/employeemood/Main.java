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
//        Display RawData only for a particular import type using method overload
//        fileImporter.displayRecordsFromRawDataMap(FileImporter.ImportTypeEnum.MOOD);

        //Validate import files
        FileImporterValidator fileImporterValidator = new FileImporterValidator();
        fileImporterValidator.validateData(FileImporter.ImportTypeEnum.MOOD);
        fileImporterValidator.validateData(FileImporter.ImportTypeEnum.USER);
        fileImporterValidator.validateData(FileImporter.ImportTypeEnum.PROJECT);

        //Create objects from loaded data
        FileImporterObjectCreator fileImporterObjectCreator = new FileImporterObjectCreator();
        fileImporterObjectCreator.createObjectInstanceFromData(FileImporter.ImportTypeEnum.MOOD);
        fileImporterObjectCreator.createObjectInstanceFromData(FileImporter.ImportTypeEnum.USER);
        fileImporterObjectCreator.createObjectInstanceFromData(FileImporter.ImportTypeEnum.PROJECT);


        MoodData md = new MoodData();

        md.displayList(MoodData.moodList);
        md.displayList(MoodData.userList);
        md.displayList(MoodData.projectList);

    }
}
