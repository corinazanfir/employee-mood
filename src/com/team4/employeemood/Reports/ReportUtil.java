package com.team4.employeemood.Reports;

import com.team4.employeemood.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReportUtil {

    public enum PredefinedReportingPeriodsEnum {
        CurrentWeek,
        PreviousWeek,
        CurrentMonth,
        PreviousMonth;
    }

    Map<String, List<Date>> predefinedReportingPeriodsMap = new HashMap<>();


    public static DecimalFormat df2 = new DecimalFormat("#.##");
    public static SimpleDateFormat timestampDateFormat = new SimpleDateFormat("dd.MM.yyyy hh-mm-ss");
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

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


    public void calculatePredefinedPeriods() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        // get today and clear time of day
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);

        Date currentDate = cal.getTime();

        // get start of this week in milliseconds
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());

        Date currentWeekStart = cal.getTime();

        List currentWeekDateRange = new ArrayList();
        currentWeekDateRange.add(currentWeekStart);
        currentWeekDateRange.add(currentDate);

        predefinedReportingPeriodsMap.put(PredefinedReportingPeriodsEnum.CurrentWeek.toString(), currentWeekDateRange);

        cal.add(Calendar.DATE, -1);
        Date previousWeekEnd = cal.getTime();

        cal.add(Calendar.DATE, -6);
        Date previousWeekStart = cal.getTime();

        List previousWeekDateRange = new ArrayList();
        previousWeekDateRange.add(previousWeekStart);
        previousWeekDateRange.add(previousWeekEnd);

        predefinedReportingPeriodsMap.put(PredefinedReportingPeriodsEnum.PreviousWeek.toString(), previousWeekDateRange);

    }


    public void displayPredefinedPeriodsCalculation() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("\nCalculated time periods are:");
        for (Map.Entry<String, List<Date>> entry : predefinedReportingPeriodsMap.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
            System.out.println("    from " + sdf.format(entry.getValue().get(0)) + " to " + sdf.format(entry.getValue().get(1)));
        }
    }


    public int getTotalNumberOfTeamMembers(String projectName) {

        int counter = 0;
        for (User user : UserData.userList) {
            if (user.getProjectName().equalsIgnoreCase(projectName)) {
                counter++;
            }
        }
        return counter;
    }

    public int getTotalNumberOfTeamMembers(String projectName, Date fromDate, Date toDate) {

        int counter = 0;
        for (User user : UserData.userList) {
            if (user.getProjectName().equalsIgnoreCase(projectName) && !user.getEmploymentDate().before(fromDate) && !user.getEmploymentDate().after(toDate)) {
                counter++;
            }
        }
        return counter;
    }

    public int getNumberOfTeamMembersWithFeedbackSent(String projectName) {

        int counter = 0;
        Set uniqueUsers = new HashSet();

        for (User user : UserData.userList) {
            if (user.getProjectName().equalsIgnoreCase(projectName)) {

                for (Mood mood : MoodData.moodList) {
                    if (mood.getUsername().equals(user.getUsername())) {
                        uniqueUsers.add(user);
                    }
                }
            }
        }
        return uniqueUsers.size();
    }

    public int getNumberOfTeamMembersWithFeedbackSent(String projectName, Date fromDate, Date toDate) {

        int counter = 0;
        Set uniqueUsers = new HashSet();

        for (User user : UserData.userList) {
            if (user.getProjectName().equalsIgnoreCase(projectName)) {

                for (Mood mood : MoodData.moodList) {
                    if (mood.getUsername().equals(user.getUsername()) && !mood.getDate().before(fromDate) && !mood.getDate().after(toDate)) {
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

    public double getAverageRatingForUser(String username, Date fromDate, Date toDate) {
        int countMoodSubmissions = 0;
        int ratingAcc = 0;
        double result = 0;

        for (Mood mood : MoodData.moodList) {
            if (mood.getUsername().equals(username) && !mood.getDate().before(fromDate) && !mood.getDate().after(toDate)) {
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
            if (user.getProjectName().equalsIgnoreCase(projectName)) {
                for (Mood mood : MoodData.moodList) {
                    if (mood.getUsername().equalsIgnoreCase(user.getUsername())) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public int getNumberOfMoodSubmissionsByProject(String projectName, Date fromDate, Date toDate) {

        int counter = 0;

        for (User user : UserData.userList) {
            if (user.getProjectName().equalsIgnoreCase(projectName)) {
                for (Mood mood : MoodData.moodList) {
                    if (mood.getUsername().equalsIgnoreCase(user.getUsername()) && !mood.getDate().before(fromDate) && !mood.getDate().after(toDate)) {
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
            if (user.getProjectName().equalsIgnoreCase(projectName)) {
                for (Mood mood : MoodData.moodList) {
                    if (mood.getUsername().equalsIgnoreCase(user.getUsername())) {
                        totalRatingAcc = totalRatingAcc + mood.getDayRating();
                    }
                }
            }
        }
        return totalRatingAcc;
    }

    public int getTotalRatingValueForSubmissionsByProject(String projectName, Date fromDaate, Date toDate) {

        int totalRatingAcc = 0;

        for (User user : UserData.userList) {
            if (user.getProjectName().equalsIgnoreCase(projectName)) {
                for (Mood mood : MoodData.moodList) {
                    if (mood.getUsername().equalsIgnoreCase(user.getUsername()) && !mood.getDate().before(fromDaate) && !mood.getDate().after(toDate)) {
                        totalRatingAcc = totalRatingAcc + mood.getDayRating();
                    }
                }
            }
        }
        return totalRatingAcc;
    }

    public String getManagerByProject(String projectName) {

        for (Project project : ProjectData.projectList) {
            if (project.getProjectName().equalsIgnoreCase(projectName)) {
                return project.getProjectManager();
            }
        }
        return null;
    }

    public Double getAverageMoodRatingForProject(String projectName) {

        ReportUtil reportUtil = new ReportUtil();

        Double result = null;
        for (Project project : ProjectData.projectList) {
            if (project.getProjectName().equalsIgnoreCase(projectName)) {
                int totalRating = reportUtil.getTotalRatingValueForSubmissionsByProject(project.getProjectName());
                int numberOfSubmissions = reportUtil.getNumberOfMoodSubmissionsByProject(project.getProjectName());
                result = (double) totalRating / numberOfSubmissions;
            }
        }
        return result;
    }

    public Double getAverageMoodRatingForProject(String projectName, Date fromDate, Date toDate) {

        ReportUtil reportUtil = new ReportUtil();

        Double result = null;
        for (Project project : ProjectData.projectList) {
            if (project.getProjectName().equalsIgnoreCase(projectName)) {
                int totalRating = reportUtil.getTotalRatingValueForSubmissionsByProject(project.getProjectName(), fromDate, toDate);
                int numberOfSubmissions = reportUtil.getNumberOfMoodSubmissionsByProject(project.getProjectName(), fromDate, toDate);
                result = (double) totalRating / numberOfSubmissions;
            }
        }
        return result;
    }
}

