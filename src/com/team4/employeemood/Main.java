package com.team4.employeemood;

import com.team4.employeemood.FileImporter.FileImporter;
import com.team4.employeemood.FileImporter.FileImporterObjectCreator;
import com.team4.employeemood.FileImporter.FileImporterValidator;
import com.team4.employeemood.FileImporter.Util;
import com.team4.employeemood.Reports.HappiestProjectsReport;
import com.team4.employeemood.Reports.ReportUtil;
import com.team4.employeemood.Reports.TeamAverageReport;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {

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
        UserData ud = new UserData();

//        md.displayList(MoodData.moodList);
//        md.displayList(MoodData.userList);
//        md.displayList(MoodData.projectList);


        ReportUtil reportUtil = new ReportUtil();

//      reusable methods for creating necessary report

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//        Date date = sdf.parse("25/11/2020");
//
//        System.out.println(date);

//        System.out.println("Total number of team members: " + reportUtil.getTotalNumberOfTeamMembers("project a"));
        System.out.println("Unique team member that have sent feedback: " + reportUtil.getNumberOfTeamMembersWithFeedbackSent("project a"));
        System.out.println("Unique team member that have sent feedback: " + sdf.format(sdf.parse("25/11/2020")) + " to " + sdf.format(sdf.parse("15/12/2020")) + " is - "
                + reportUtil.getNumberOfTeamMembersWithFeedbackSent("project a", sdf.parse("25/11/2020"), sdf.parse("15/12/2020")));


        //        System.out.println("Rating Average for user catalin.gheorghe@moodproject - " + reportUtil.getAverageRatingForUser("catalin.gheorghe@moodproject"));
        System.out.println("Number of mood submissions for Project A - " + reportUtil.getNumberOfMoodSubmissionsByProject("project a"));
        System.out.println("Number of mood submissions for Project A - " + sdf.format(sdf.parse("25/11/2020")) + " to " + sdf.format(sdf.parse("15/12/2020")) + " is - " + reportUtil.getNumberOfMoodSubmissionsByProject("project a", sdf.parse("25/11/2020"), sdf.parse("15/12/2020")));

        System.out.println("Total Rating Accumulator for Project A for all records- " + reportUtil.getTotalRatingValueForSubmissionsByProject("project a"));
        System.out.println("Total Rating Accumulator for Project A for records from - " + sdf.format(sdf.parse("19/11/2020")) + " to " + sdf.format(sdf.parse("19/12/2020")) + " is - "
                + reportUtil.getTotalRatingValueForSubmissionsByProject("project a", sdf.parse("19/11/2020"), sdf.parse("19/11/2020")));

        System.out.println("Average Mood Rating for Project A - " + reportUtil.getAverageMoodRatingForProject("project a"));
        System.out.println("Average Mood Rating for Project A for records from - " + sdf.format(sdf.parse("25/11/2020")) + " to " + sdf.format(sdf.parse("15/12/2020")) + " is - " + reportUtil.getAverageMoodRatingForProject("project a", sdf.parse("25/11/2020"), sdf.parse("15/12/2020")));


        //REPORTING
        TeamAverageReport teamAverageReport = new TeamAverageReport();
        //with custom date range
        teamAverageReport.generateReport("project a", true, true, sdf.parse("15/11/2020"), sdf.parse("05/12/2020"));

        //with predefined date range
        teamAverageReport.generateReport("project a", true, true, ReportUtil.PredefinedReportingPeriodsEnum.CurrentWeek);

        HappiestProjectsReport happiestProjectsReport = new HappiestProjectsReport();
        //with custom date range
        happiestProjectsReport.generateReport(true, true, sdf.parse("15/11/2020"), sdf.parse("05/12/2020"));
        //with predefined date range
        happiestProjectsReport.generateReport(true, true, ReportUtil.PredefinedReportingPeriodsEnum.CurrentMonth);

        reportUtil.calculatePredefinedPeriods();
        reportUtil.displayPredefinedPeriodsCalculation();

        //testing fore predefined reporting periods
//        System.out.println(reportUtil.getPredefinedPeriodStartDate(ReportUtil.PredefinedReportingPeriodsEnum.CurrentMonth));
//        System.out.println(reportUtil.getPredefinedPeriodEndDate(ReportUtil.PredefinedReportingPeriodsEnum.CurrentMonth));


    }
}

