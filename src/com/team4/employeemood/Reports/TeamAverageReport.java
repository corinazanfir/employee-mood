package com.team4.employeemood.Reports;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class TeamAverageReport {

    private Integer numberOfMoodSubmissions;
    private Double teamRatingAverage;
    private Integer totalRating;


//    Trebuie să existe posibilitatea unui mini raport, care să spună în primă fază care este media generală
//    a stării de spirit a echipei și numărul de intrări. Acest mini raport trebuie să afișeze într-un fișier
//    “General team mood is ..., ... employees have given mood information” și să pună media, care poate fi un
//    număr rațional cu două zecimale, plus numărul de angajați care au dat informații.


    public void generateReport(String projectName, boolean writeToConsole, boolean writeToFile) throws IOException {

        ReportUtil reportUtil = new ReportUtil();

        this.numberOfMoodSubmissions = reportUtil.getNumberOfMoodSubmissionsByProject(projectName);
        this.totalRating = reportUtil.getTotalRatingValueForSubmissionsByProject(projectName);
        this.teamRatingAverage = (double) totalRating / numberOfMoodSubmissions;

        String[] reportLines = new String[8];
        String title = "----------[ Mood statistics for " + projectName.toUpperCase() + " ]----------";

        reportLines[0] = title;
        reportLines[1] = "-".repeat(title.length());
        reportLines[2] = "General team mood rating is - " + ReportUtil.df2.format(teamRatingAverage);
        reportLines[3] = "Total number of project members - " + reportUtil.getTotalNumberOfTeamMembers(projectName);
        reportLines[4] = "Number of users that have provided feedback - " + reportUtil.getNumberOfTeamMembersWithFeedbackSent(projectName);
        reportLines[5] = "Number of feedback submissions received - " + reportUtil.getNumberOfMoodSubmissionsByProject(projectName);
        reportLines[6] = "Current project manager - " + reportUtil.getManagerByProject(projectName);
        reportLines[7] = "-".repeat(title.length());

        //check flag for printing to console
        if (writeToConsole == true) {
            for (String line : reportLines) {
                System.out.println(line);
            }
        }

        //check flag for printing to file
        if (writeToFile == true) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Team Average Mood Statistics Report - " + projectName.toUpperCase() + " " + ReportUtil.timestampDateFormat.format(new Date()) + ".txt", false));
            for (String line : reportLines) {
                writer.append(line);
                writer.append("\n");
            }
            writer.close();
        }
    }


}
