package com.team4.employeemood.Reports;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeamAverageReport {

//    Trebuie să existe posibilitatea unui mini raport, care să spună în primă fază care este media generală
//    a stării de spirit a echipei și numărul de intrări. Acest mini raport trebuie să afișeze într-un fișier
//    “General team mood is ..., ... employees have given mood information” și să pună media, care poate fi un
//    număr rațional cu două zecimale, plus numărul de angajați care au dat informații.

    public void generateReport(String projectName, boolean writeToConsole, boolean writeToFile, Date fromDate, Date toDate) throws IOException {

        ReportUtil reportUtil = new ReportUtil();

        String title = "----------[ Mood statistics for " + projectName.toUpperCase() + " ]----------";
        List<String> reportLines = new ArrayList<>();

        reportLines.add(title);
        reportLines.add("-".repeat(title.length()));
        reportLines.add("Reporting period: " + ReportUtil.sdf.format(fromDate) + " to " + ReportUtil.sdf.format(toDate));
        reportLines.add("General team mood rating is - " + ReportUtil.df2.format(reportUtil.getAverageMoodRatingForProject(projectName, fromDate, toDate)));
        reportLines.add("Total number of project members - " + reportUtil.getTotalNumberOfTeamMembers(projectName, fromDate, toDate));
        reportLines.add("Number of users that have provided feedback - " + reportUtil.getNumberOfTeamMembersWithFeedbackSent(projectName, fromDate, toDate));
        reportLines.add("Number of feedback submissions received - " + reportUtil.getNumberOfMoodSubmissionsByProject(projectName, fromDate, toDate));
        reportLines.add("Current project manager - " + reportUtil.getManagerByProject(projectName));
        reportLines.add("-".repeat(title.length()));

        //check flag for printing to console
        if (writeToConsole == true) {
            writeToConsole(reportLines);
        }

        //check flag for printing to file
        if (writeToFile == true) {
            writeToFile(projectName, reportLines, fromDate, toDate);
        }
    }

    private void writeToFile(String projectName, List<String> reportLines, Date fromDate, Date toDate) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Team Average Mood Statistics Report - " + projectName.toUpperCase() +
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
