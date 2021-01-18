package com.team4.employeemood.FileImporter;

import java.util.Collections;

public class Util {

    //define predefined import types by adding an additional import type to the enum
    public enum ImportTypeEnum {
        MOOD,
        USER,
        PROJECT
    }

    final static String userImportPattern = "(.*);(.*);(([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9]?[0-9][0-9]));(([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9]?[0-9][0-9]));(.*)";
    final static String projectImportPattern = "(.*);(.*);(([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9]?[0-9][0-9]));(.*)";
    final static String moodImportPattern = "([1-5]);(.*);(.*?);(.*?);(([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9]?[0-9][0-9]));(.*)";

    public static String repeatString(String str, int repeatTimes) {
        return String.join("", Collections.nCopies(repeatTimes, str));
    }
}
