package com.team4.employeemood.FileImporter;

import com.team4.employeemood.Exceptions.PatternNotMatchingException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileImporterValidator {

    // This class is used to verify if the import files have the corresponding pattern format

    public String getMoodImportPattern() {
        return Util.moodImportPattern;
    }

    public String getUserImportPattern() {
        return Util.userImportPattern;
    }

    public String getProjectImportPattern() {
        return Util.projectImportPattern;
    }

    public void validateData(Util.ImportTypeEnum importTypeEnum) {

        int recordCounter = 0; //Added a counter to display the number of processed records for each import type
        if (!FileImporter.importRawDataMap.containsKey(importTypeEnum)) {
            System.out.println("\nWARNING: Unable to perform data validation. No data available for the import type: " + importTypeEnum);
        } else {
            System.out.println(("-").repeat(25) + "[ Pattern validation for " + importTypeEnum + " data]" + ("-").repeat(25));
            for (String string : FileImporter.importRawDataMap.get(importTypeEnum)) {
                patternCheck(string, importTypeEnum);
                recordCounter++;
            }
            System.out.println(("-").repeat(150)+"\n[Records processed: " + recordCounter + " ]");

        }
    }

    public void patternCheck(String inputString, Util.ImportTypeEnum importTypeEnum) {

        //Use the switch statement to define the pattern for each type of import
        Pattern pattern = null;

        switch (importTypeEnum) {
            case MOOD:
                pattern = Pattern.compile(Util.moodImportPattern);
                break;
            case USER:

                pattern = Pattern.compile(Util.userImportPattern);
                break;

            case PROJECT:
                pattern = Pattern.compile(Util.projectImportPattern);
                break;

            default:
                break;
        }

        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            System.out.println("[OK] Pattern match for record: " + inputString);
        } else {
            try {
                throw new PatternNotMatchingException(importTypeEnum.toString().toUpperCase() + " data not properly defined. Certain fields are not using the expected format pattern.\nRejected record is: " + inputString);
            } catch (PatternNotMatchingException e) {
                e.printStackTrace();
            }
        }
    }
}
