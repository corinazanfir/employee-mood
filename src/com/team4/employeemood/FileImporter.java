package com.team4.employeemood;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FileImporter {
    //define predefined import by adding an additional import type to the enum
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
            List<String> importTypeData = new ArrayList<>();
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
            System.out.println("\nDisplay list for: " + importTypeEnum + "\n" + ("-").repeat(70));
            for (String value : importRawDataMap.get(importTypeEnum)) {
                System.out.println("value:" + value);
            }
        }
    }
}



