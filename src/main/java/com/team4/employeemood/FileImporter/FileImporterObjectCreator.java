package com.team4.employeemood.FileImporter;

import com.team4.employeemood.*;
import com.team4.employeemood.Exceptions.PatternNotMatchingException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileImporterObjectCreator {

    public void createObjectInstanceFromData(Util.ImportTypeEnum importTypeEnum) {

        int recordCounter = 0; //Added a counter to display the number of processed records for each import type
        if (!FileImporter.importRawDataMap.containsKey(importTypeEnum)) {
            System.out.println("\nWARNING: Unable to create object instances. No data available for the import type: " + importTypeEnum);
        } else {
            System.out.println(("-").repeat(25) + "[ Object creation for " + importTypeEnum + " data]" + ("-").repeat(25));
            for (String string : FileImporter.importRawDataMap.get(importTypeEnum)) {

                switch (importTypeEnum) {
                    case MOOD:
                        instantiateMood(string);
                        break;
                    case PROJECT:
                        instantiateProject(string);
                        break;
                    case USER:
                        instantiateUser(string);
                        break;
                }
                recordCounter++;
            }
            System.out.println("[Records processed: " + recordCounter + " ]");
        }
    }

    private void instantiateUser(String inputString) {
        User user = new User();
        FileImporterValidator fileImporterValidator = new FileImporterValidator();

        Pattern pattern = Pattern.compile(fileImporterValidator.getUserImportPattern());
        Matcher matcher = pattern.matcher(inputString);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        if (matcher.find()) {
            user.setFirstName(matcher.group(1));
            user.setLastName(matcher.group(2));
            try {
                user.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(matcher.group(3)));
            } catch (ParseException e) {
                e.printStackTrace();
            };
            try {
                user.setEmploymentDate(new SimpleDateFormat("dd/MM/yyyy").parse( matcher.group(7)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            user.setProjectName(matcher.group(11));
            user.setUsername();

        } else {
            try {
                throw new PatternNotMatchingException(Util.ImportTypeEnum.USER + " data not properly defined. Certain fields are not using the expected format.\nRejected record is: " + inputString);
            } catch (PatternNotMatchingException e) {
                e.printStackTrace();
            }
        }

        UserData.userList.add(user);
    }

    private void instantiateProject(String inputString) {
        Project project = new Project();
        FileImporterValidator fileImporterValidator = new FileImporterValidator();

        Pattern pattern = Pattern.compile(fileImporterValidator.getProjectImportPattern());
        Matcher matcher = pattern.matcher(inputString);

//        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        if (matcher.find()) {
            project.setProjectName(matcher.group(1));
            project.setProjectBudget(Integer.parseInt(matcher.group(2)));
            try {
                project.setProjectDueDate(new SimpleDateFormat("dd/MM/yyyy").parse(matcher.group(3)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            project.setProjectManager(matcher.group(7));

        } else {
            try {
                throw new PatternNotMatchingException(Util.ImportTypeEnum.PROJECT + " data not properly defined. Certain fields are not using the expected format.\nRejected record is: " + inputString);
            } catch (PatternNotMatchingException e) {
                e.printStackTrace();
            }
        }
        ProjectData.projectList.add(project);
    }

    public void instantiateMood(String inputString) {
        Mood mood = new Mood();
        FileImporterValidator fileImporterValidator = new FileImporterValidator();

        Pattern pattern = Pattern.compile(fileImporterValidator.getMoodImportPattern());
        Matcher matcher = pattern.matcher(inputString);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        if (matcher.find()) {
            mood.setDayRating(Integer.parseInt(matcher.group(1)));
            mood.setComment(matcher.group(2));
            mood.setPreviousDayChange(matcher.group(3));
            mood.setImprovementIdea(matcher.group(4));
            try {
                mood.setDate(new SimpleDateFormat("dd/MM/yyyy").parse(matcher.group(5)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            mood.setUsername(matcher.group(9));
        } else {
            try {
                throw new PatternNotMatchingException(Util.ImportTypeEnum.MOOD + " data not properly defined. Certain fields are not using the expected format.\nRejected record is: " + inputString);
            } catch (PatternNotMatchingException e) {
                e.printStackTrace();
            }
        }
        MoodData.moodList.add(mood);
    }
}
