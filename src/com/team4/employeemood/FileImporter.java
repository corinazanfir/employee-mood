package com.team4.employeemood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileImporter {

    //# This class is designed ONLY to read data from CSV files and populate the data in a map.


    //define predefined import types by adding an additional import type to the enum
    enum ImportTypeEnum {
        MOOD,
        USER,
        PROJECT
    }

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

    //Method overload to be able to filter based an import type.
    public void displayRecordsFromRawDataMap(ImportTypeEnum importType) {

        System.out.println(("-").repeat(25) + "[ RAW DATA IMPORTER ]" + ("-").repeat(25));
        for (ImportTypeEnum importTypeEnum : importRawDataMap.keySet()) {
            if (importTypeEnum.equals(importType)) {
                System.out.println("\nDisplay raw data list for the import type: " + importTypeEnum + "\n" + ("-").repeat(70));
                for (String value : importRawDataMap.get(importTypeEnum)) {
                    System.out.println("value:" + value);
                }
            }
        }
    }

    public void displayRecordsFromRawDataMap() {

        System.out.println(("-").repeat(25) + "[ RAW DATA IMPORTER ]" + ("-").repeat(25));
        for (ImportTypeEnum importTypeEnum : importRawDataMap.keySet()) {
            System.out.println("\nDisplay raw data list for the import type: " + importTypeEnum + "\n" + ("-").repeat(70));
            for (String value : importRawDataMap.get(importTypeEnum)) {
                System.out.println("value:" + value);
            }
        }
    }
}





