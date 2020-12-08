package com.team4.employeemood.Reports;

import com.team4.employeemood.Project;
import com.team4.employeemood.ProjectData;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class HappiestProjectsReport {

    //create a map store the projectname and the previously calculated average project mood rating
    Map<String, Double> averageMoodRating = new HashMap<>();

    public void generateReport(boolean writeToConsole, boolean writeToFile, Date fromDate, Date toDate) throws IOException {

        precalculateDataForReport(fromDate, toDate);

        List<String> reportLines = new ArrayList<>();

        reportLines.add("---------------[ Top Projects by Mood Rating ]---------------");
        reportLines.add("Reporting period: " + ReportUtil.sdf.format(fromDate) + " to " + ReportUtil.sdf.format(toDate));
        reportLines.add("The project with the highest employee mood rating are: \n");
        reportLines.add("Project Name | Average rating value");
        reportLines.add("-".repeat("Project Name | Average rating value".length()));
        for (Map.Entry entry : averageMoodRating.entrySet()) {
            reportLines.add(entry.getKey() + " ".repeat(13 - entry.getKey().toString().length()) + "| " + ReportUtil.df2.format(entry.getValue()));
        }


        //check flag for printing to console
        if (writeToConsole == true) {
            writeToConsole(reportLines);
        }

        //check flag for printing to file
        if (writeToFile == true) {
            writeToFile(reportLines, fromDate, toDate);
        }

    }

    private void precalculateDataForReport(Date fromDate, Date toDate) {
        ReportUtil reportUtil = new ReportUtil();
        for (Project project : ProjectData.projectList) {
            double averageRating = reportUtil.getAverageMoodRatingForProject(project.getProjectName(), fromDate, toDate);
            averageMoodRating.put(project.getProjectName(), averageRating);
        }

        //sort map in descending order by values
        averageMoodRating = averageMoodRating.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    //used for testing
    public void displayMap() {
        System.out.println("\nDisplay Map key & values:");
        for (Map.Entry entry : averageMoodRating.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private void writeToFile(List<String> reportLines, Date fromDate, Date toDate) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Top Mood Rating Projects - " +
                " " + ReportUtil.sdf.format(fromDate) + "-" + ReportUtil.sdf.format(toDate) + ".txt", false));
        for (String line : reportLines) {
            writer.append(line);
            writer.append("\n");
        }
        writer.close();
    }

    private void writeToConsole(List<String> reportLines) {
        for (String line : reportLines) {
            System.out.println(line);
        }
    }
}