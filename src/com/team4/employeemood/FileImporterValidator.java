package com.team4.employeemood;

import com.team4.employeemood.exceptions.MoodConstructException;

import java.text.ParseException;

public class FileImporterValidator {


    public void validateData(FileImporter.ImportTypeEnum importTypeEnum) {

        if (!FileImporter.importRawDataMap.containsKey(importTypeEnum)) {
            System.out.println("\nWARNING: Unable to perform data validation. No data available for the import type: " + importTypeEnum);
        } else {

            for (String string : FileImporter.importRawDataMap.get(importTypeEnum)) {
                try {

                    switch (importTypeEnum) {

                        case MOOD:
                            Mood mood = new Mood(string);
                            MoodData.moodList.add(mood);
                            break;

                        case USER:
                            User user = new User(string);
                            break;
                    }

                    } catch(MoodConstructException e){
                        e.printStackTrace();
                    } catch(ParseException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
