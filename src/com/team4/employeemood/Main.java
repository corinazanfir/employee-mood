package com.team4.employeemood;

import com.team4.employeemood.FileImporter.FileImporter;
import com.team4.employeemood.FileImporter.FileImporterObjectCreator;
import com.team4.employeemood.FileImporter.FileImporterValidator;
import com.team4.employeemood.FileImporter.Util;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {

        FileImporter fileImporter = new FileImporter();

        fileImporter.loadDataFromFile("MoodSampleFile.csv", Util.ImportTypeEnum.MOOD);
        fileImporter.loadDataFromFile("MoodSampleFile2.csv", Util.ImportTypeEnum.MOOD);
        fileImporter.loadDataFromFile("ProjectSampleFile.csv", Util.ImportTypeEnum.PROJECT);
        fileImporter.loadDataFromFile("UsersSampleFile.csv", Util.ImportTypeEnum.USER);

//        fileImporter.displayRecordsFromRawDataMap();
//        Display RawData only for a particular import type using method overload
//        fileImporter.displayRecordsFromRawDataMap(FileImporter.ImportTypeEnum.MOOD);

        //Validate import files
        FileImporterValidator fileImporterValidator = new FileImporterValidator();
//        fileImporterValidator.validateData(Util.ImportTypeEnum.MOOD);
//        fileImporterValidator.validateData(Util.ImportTypeEnum.USER);
//        fileImporterValidator.validateData(Util.ImportTypeEnum.PROJECT);

        //Create objects from loaded data
        FileImporterObjectCreator fileImporterObjectCreator = new FileImporterObjectCreator();
        fileImporterObjectCreator.createObjectInstanceFromData(Util.ImportTypeEnum.MOOD);
        fileImporterObjectCreator.createObjectInstanceFromData(Util.ImportTypeEnum.USER);
        fileImporterObjectCreator.createObjectInstanceFromData(Util.ImportTypeEnum.PROJECT);


        MoodData md = new MoodData();

//        md.displayList(MoodData.moodList);
//        md.displayList(MoodData.userList);
//        md.displayList(MoodData.projectList);


        for (Project project: MoodData.projectList) {

            System.out.println("\nProject: " + project);
            System.out.println("Team members:");

            for (User user : MoodData.userList) {
              if (project.getProjectName().equals(user.getProjectName())){
                  System.out.println(user);
              }

            }
        }

    }
}
