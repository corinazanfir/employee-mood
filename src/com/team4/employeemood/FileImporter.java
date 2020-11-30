package com.team4.employeemood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileImporter {

    //This class is designed ONLY to read data from CSV files and populate the data in a map.
    //Regex Pattern/Matcher should be defined in: INDIVIDUAL Classes or a centralized class that performs only this activity??? TO BE CLARIFIED


    //define predefined import by adding an additional import type to the enum
    enum ImportTypeEnum {
        MOOD,
        USER,
        PROJECT
    }

//REQUIREMENTS QUESTION: will there be only 1 file imported for each Import Type?
//                    OR there will be multiple files and they should be appended to the existing ArrayList
//             Example: only 1 file that would contain the Mood data from all employees OR each employee will have a dedicated file or a dedicated file for each workday

    public static Map<ImportTypeEnum, List<String>> importRawDataMap = new HashMap<>();

    public void loadDataFromFile(String filePath, ImportTypeEnum typeOfImport) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();

            List<String> importTypeData = new ArrayList<>(); //create ArrayList that will be populated with line by line data from file

            if (importRawDataMap.containsKey(typeOfImport)) {
                List<String> existingData = importRawDataMap.get(typeOfImport); //check if there is any data for that import type
                importTypeData.addAll(existingData); /* add existing data to the used ArrayList (the functionality is useful in case there are multiple
                                                        files imported for the same import type */
            }

            while (line != null) {

                importTypeData.add(line); //populate ArrayList with line by line raw string data from import file

                line = reader.readLine();
                FileImporter.importRawDataMap.put(typeOfImport, importTypeData); //put ArrayList under the corresponding Key in the map
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayRecordsFromRawDataMap() {

        for (ImportTypeEnum importTypeEnum : importRawDataMap.keySet()) {
            System.out.println("\nDisplay raw data list for the import type: " + importTypeEnum + "\n" + ("-").repeat(70));
            for (String value : importRawDataMap.get(importTypeEnum)) {
                System.out.println("value:" + value);
            }
        }
    }
}



