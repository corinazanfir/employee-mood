package com.team4.employeemood;

import com.team4.employeemood.FileImporter.FileImporter;
import com.team4.employeemood.FileImporter.FileImporterObjectCreator;
import com.team4.employeemood.FileImporter.FileImporterValidator;
import com.team4.employeemood.FileImporter.Util;
import com.team4.employeemood.Reports.HappiestProjectsReport;
import com.team4.employeemood.Reports.ReportUtil;
import com.team4.employeemood.Reports.TeamAverageReport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class EmployeemoodApplication {

    public static void main(String[] args) throws IOException, ParseException {
        SpringApplication.run(EmployeemoodApplication.class, args);

        FileImporter fileImporter = new FileImporter();

        fileImporter.loadDataFromFile("SampleData/MoodSampleFile.csv", Util.ImportTypeEnum.MOOD);
        fileImporter.loadDataFromFile("SampleData/MoodSampleFile2.csv", Util.ImportTypeEnum.MOOD);
        fileImporter.loadDataFromFile("SampleData/ProjectSampleFile.csv", Util.ImportTypeEnum.PROJECT);
        fileImporter.loadDataFromFile("SampleData/UsersSampleFile.csv", Util.ImportTypeEnum.USER);
//        fileImporter.loadDataFromFolder("SampleData/MoodData",Util.ImportTypeEnum.MOOD);

        //Display loaded raw data
        fileImporter.displayRecordsFromRawDataMap(); //For all imported raw data
//        fileImporter.displayRecordsFromRawDataMap(Util.ImportTypeEnum.MOOD); //for a specific import type

        //Validate import files
        FileImporterValidator fileImporterValidator = new FileImporterValidator();
        fileImporterValidator.validateData(Util.ImportTypeEnum.MOOD);
        fileImporterValidator.validateData(Util.ImportTypeEnum.USER);
        fileImporterValidator.validateData(Util.ImportTypeEnum.PROJECT);
//
        //Create objects from loaded data
        FileImporterObjectCreator fileImporterObjectCreator = new FileImporterObjectCreator();
        fileImporterObjectCreator.createObjectInstanceFromData(Util.ImportTypeEnum.MOOD);
        fileImporterObjectCreator.createObjectInstanceFromData(Util.ImportTypeEnum.USER);
        fileImporterObjectCreator.createObjectInstanceFromData(Util.ImportTypeEnum.PROJECT);



        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // REPORTING
        // TEAM AVERAGE MOOD REPORT
        TeamAverageReport teamAverageReport = new TeamAverageReport();

        //with custom date range
//        System.out.println();
//        teamAverageReport.generateReport("project a", true, true, sdf.parse("15/11/2020"),sdf.parse("05/12/2020"));

        //with predefined date range
        System.out.println();
        teamAverageReport.generateReport("project a", true, true, ReportUtil.PredefinedReportingPeriodsEnum.CurrentWeek);


        HappiestProjectsReport happiestProjectsReport = new HappiestProjectsReport();
        //with custom date range
        happiestProjectsReport.generateReport(true, true, sdf.parse("15/11/2020"), sdf.parse("05/12/2020"));
        //with predefined date range
        happiestProjectsReport.generateReport(true, true, ReportUtil.PredefinedReportingPeriodsEnum.CurrentMonth);


        ReportUtil reportUtil = new ReportUtil();
        reportUtil.calculatePredefinedPeriods();
        reportUtil.displayPredefinedPeriodsCalculation();

    }
}
