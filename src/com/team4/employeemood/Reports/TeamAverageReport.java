package com.team4.employeemood.Reports;

import org.w3c.dom.ls.LSOutput;

public class TeamAverageReport {

    private Integer numberOfMoodSubmissions;
    private Double teamRatingAverage;
    private Integer totalRating;


//    Trebuie să existe posibilitatea unui mini raport, care să spună în primă fază care este media generală
//    a stării de spirit a echipei și numărul de intrări. Acest mini raport trebuie să afișeze într-un fișier
//    “General team mood is ..., ... employees have given mood information” și să pună media, care poate fi un
//    număr rațional cu două zecimale, plus numărul de angajați care au dat informații.


    public void generateReport(String projectName) {

        ReportUtil reportUtil = new ReportUtil();

        this.numberOfMoodSubmissions = reportUtil.getNumberOfMoodSubmissionsByProject(projectName);
        this.totalRating = reportUtil.getTotalRatingValueForSubmissionsByProject(projectName);
        this.teamRatingAverage = (double) totalRating / numberOfMoodSubmissions;

        String title = "----------[ Mood statistics for " + projectName.toUpperCase() + " ]----------";
        System.out.println(title);
        System.out.println("-".repeat(title.length()));
        System.out.println("General team mood rating is - " + ReportUtil.df2.format(teamRatingAverage));
        System.out.println("Number of users that have provided feedback - " + reportUtil.getNumberOfTeamMembersWithFeedbackSent(projectName));
        System.out.println("Number of feedback submissions received - " + reportUtil.getNumberOfMoodSubmissionsByProject(projectName));
        System.out.println("Current project manager - " + reportUtil.getManagerByProject(projectName));
        System.out.println("-".repeat(title.length()));
    }


}
