package com.team4.employeemood.Reports;

import com.team4.employeemood.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class ReportUtil {

    public static DecimalFormat df2 = new DecimalFormat("#.##");
    public static SimpleDateFormat timestampDateFormat = new SimpleDateFormat("dd.MM.yyyy hh-mm-ss");

    // DONE
//    Trebuie să existe posibilitatea unui mini raport, care să spună în primă fază care este media generală
//    a stării de spirit a echipei și numărul de intrări. Acest mini raport trebuie să afișeze într-un fișier
//    “General team mood is ..., ... employees have given mood information” și să pună media, care poate fi un
//    număr rațional cu două zecimale, plus numărul de angajați care au dat informații.


//    Toți utilizatorii cu un daily rating mai mic decât 4 vor fi afișați într-un fișier, împreună cu rating-ul,
//    comentariul, previous day change și improvement idea.


    // DONE
//    Într-un fișier vor fi scrise toate proiectele, ordonate după gradul mediu de "happiness" al angajaților din
//    proiectul respectiv, cele mai "fericite" proiecte fiind afișate primele.


    public int getTotalNumberOfTeamMembers(String projectName) {

        int counter = 0;
        for (User user : UserData.userList) {
            if (user.getProjectName().toLowerCase().equals(projectName.toLowerCase())) {
                counter++;
            }
        }
        return counter;
    }

    public int getNumberOfTeamMembersWithFeedbackSent(String projectName) {

        int counter = 0;
        Set uniqueUsers = new HashSet();

        for (User user : UserData.userList) {
            if (user.getProjectName().toLowerCase().equals(projectName.toLowerCase())) {

                for (Mood mood : MoodData.moodList) {
                    if (mood.getUsername().equals(user.getUsername())) {
                        uniqueUsers.add(user);
                    }
                }
            }
        }
        return uniqueUsers.size();
    }

    public double getAverageRatingForUser(String username) {
        int countMoodSubmissions = 0;
        int ratingAcc = 0;
        double result = 0;

        for (Mood mood : MoodData.moodList) {
            if (mood.getUsername().equals(username)) {
                countMoodSubmissions++;
                ratingAcc = ratingAcc + mood.getDayRating();
            }
        }
        result = Double.parseDouble(df2.format((double) ratingAcc / countMoodSubmissions));
        return result;
    }

    public int getNumberOfMoodSubmissionsByProject(String projectName) {

        int counter = 0;

        for (User user : UserData.userList) {
            if (user.getProjectName().toLowerCase().equals(projectName.toLowerCase())) {
                for (Mood mood : MoodData.moodList) {
                    if (mood.getUsername().toLowerCase().equals(user.getUsername().toLowerCase())) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public int getTotalRatingValueForSubmissionsByProject(String projectName) {

        int totalRatingAcc = 0;

        for (User user : UserData.userList) {
            if (user.getProjectName().toLowerCase().equals(projectName.toLowerCase())) {
                for (Mood mood : MoodData.moodList) {
                    if (mood.getUsername().toLowerCase().equals(user.getUsername().toLowerCase())) {
                        totalRatingAcc = totalRatingAcc + mood.getDayRating();
                    }
                }
            }
        }
        return totalRatingAcc;
    }

    public String getManagerByProject(String projectName) {

        for (Project project : ProjectData.projectList) {
            if (project.getProjectName().toLowerCase().equals(projectName.toLowerCase())) {
                return project.getProjectManager();
            }
        }
        return null;
    }

    public Double getAverageMoodRatingForProject(String projectName) {

        ReportUtil reportUtil = new ReportUtil();


        Double result = null;
        for (Project project : ProjectData.projectList) {
            if (project.getProjectName().toLowerCase().equals(projectName.toLowerCase())) {
                int totalRating = reportUtil.getTotalRatingValueForSubmissionsByProject(project.getProjectName());
                int numberOfSubmissions = reportUtil.getNumberOfMoodSubmissionsByProject(project.getProjectName());
                result = (double) totalRating / numberOfSubmissions;
            }
        }

        return result;


    }
}

