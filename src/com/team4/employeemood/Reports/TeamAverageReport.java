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

    public void generateReport(String projectName, boolean writeToConsole, boolean writeToFile) throws IOException {

        ReportUtil reportUtil = new ReportUtil();

        String title = "----------[ Mood statistics for " + projectName.toUpperCase() + " ]----------";
        List<String> reportLines = new ArrayList<>();

        reportLines.add(title);
        reportLines.add("-".repeat(title.length()));
        reportLines.add("General team mood rating is - " + ReportUtil.df2.format(reportUtil.getAverageMoodRatingForProject(projectName)));
        reportLines.add("Total number of project members - " + reportUtil.getTotalNumberOfTeamMembers(projectName));
        reportLines.add("Number of users that have provided feedback - " + reportUtil.getNumberOfTeamMembersWithFeedbackSent(projectName));
        reportLines.add("Number of feedback submissions received - " + reportUtil.getNumberOfMoodSubmissionsByProject(projectName));
        reportLines.add("Current project manager - " + reportUtil.getManagerByProject(projectName));
        reportLines.add("-".repeat(title.length()));

        //check flag for printing to console
        if (writeToConsole == true) {
            writeToConsole(reportLines);
        }

        //check flag for printing to file
        if (writeToFile == true) {
            writeToFile(projectName, reportLines);
        }
    }

    private void writeToFile(String projectName, List<String> reportLines) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Team Average Mood Statistics Report - " + projectName.toUpperCase() +
                " " + ReportUtil.timestampDateFormat.format(new Date()) + ".txt", false));
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
