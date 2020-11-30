package com.team4.employeemood;

import com.team4.employeemood.exceptions.PatternNotMatchingException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileImporterValidator {

    public void validateData(FileImporter.ImportTypeEnum importTypeEnum) {

        int recordCounter=0; //Added a counter to display the number of processed records for each import type
        if (!FileImporter.importRawDataMap.containsKey(importTypeEnum)) {
            System.out.println("\nWARNING: Unable to perform data validation. No data available for the import type: " + importTypeEnum);
        } else {
            System.out.println(("-").repeat(25) + "[ Pattern validation for " + importTypeEnum + " data]" + ("-").repeat(25));
            for (String string : FileImporter.importRawDataMap.get(importTypeEnum)) {
                patternCheck(string, importTypeEnum);
                recordCounter++;
            }
            System.out.println("Records processed: "+recordCounter);
        }
    }

    public void patternCheck(String inputString, FileImporter.ImportTypeEnum importTypeEnum) {

        //Use the switch statement to define the pattern for each type of import
        Pattern pattern = null;

        switch (importTypeEnum) {
            case MOOD:
                pattern = Pattern.compile("(.*);(.*);(.*?);(.*?);(([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9]?[0-9][0-9]));(.*)");
                break;
            case USER:

                pattern = Pattern.compile("(.*);(.*);(([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9]?[0-9][0-9]));(([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9]?[0-9][0-9]));(.*)");
                break;

            case PROJECT:
                pattern = Pattern.compile("(.*);(.*);(([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9]?[0-9][0-9]));(.*)");
                break;

            default:
                break;
        }

        Matcher matcher = pattern.matcher(inputString);

        if (matcher.find()) {
            // System.out.println("pattern match");
        } else {
            try {
                throw new PatternNotMatchingException(importTypeEnum.toString().toUpperCase() + " data not properly defined. Certain fields are not using the expected format pattern.\nRejected record is: " + inputString);
            } catch (PatternNotMatchingException e) {
                e.printStackTrace();
            }
        }
    }
}
