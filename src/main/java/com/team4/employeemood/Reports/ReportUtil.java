package com.team4.employeemood.Reports;

import com.team4.employeemood.model.*;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReportUtil {

    public enum PredefinedReportingPeriodsEnum {
        CurrentWeek,
        PreviousWeek,
        CurrentMonth,
        PreviousMonth
    }

    Map<String, List<Date>> predefinedReportingPeriodsMap = new HashMap<>();


    public static DecimalFormat df2 = new DecimalFormat("#.##");
    public static SimpleDateFormat timestampDateFormat = new SimpleDateFormat("dd.MM.yyyy hh-mm-ss");
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public ReportUtil() {
        //Determine dynamically calculated date ranges - current week / previous week / current month
        calculatePredefinedPeriods();
    }

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

        List currentWeekDateRange = new ArrayList();
        currentWeekDateRange.add(getCurrentWeekStart());
        currentWeekDateRange.add(getCurrentDate());
        predefinedReportingPeriodsMap.put(PredefinedReportingPeriodsEnum.CurrentWeek.toString(), currentWeekDateRange);

        List previousWeekDateRange = new ArrayList();
        previousWeekDateRange.add(getPreviousWeekStart());
        previousWeekDateRange.add(getPreviousWeekEnd());
        predefinedReportingPeriodsMap.put(PredefinedReportingPeriodsEnum.PreviousWeek.toString(), previousWeekDateRange);

        List currentMonthDateRange = new ArrayList();
        currentMonthDateRange.add(getCurrentMonthStart());
        currentMonthDateRange.add(getCurrentDate());
        predefinedReportingPeriodsMap.put(PredefinedReportingPeriodsEnum.CurrentMonth.toString(), currentMonthDateRange);
    }

    public void displayPredefinedPeriodsCalculation() {

        System.out.println("\nDynamically calculated time periods are:");
        for (Map.Entry<String, List<Date>> entry : predefinedReportingPeriodsMap.entrySet()) {
            String key = entry.getKey();
            System.out.println(key);
            System.out.println("    from " + sdf.format(entry.getValue().get(0)) + " to " + sdf.format(entry.getValue().get(1)));
        }
    }

    public Date getPredefinedPeriodStartDate(PredefinedReportingPeriodsEnum predefinedPeriod) {
        for (Map.Entry<String, List<Date>> entry : predefinedReportingPeriodsMap.entrySet()) {
            String key = entry.getKey();
            if (key.equalsIgnoreCase(predefinedPeriod.toString())) {
                return entry.getValue().get(0);
            }
        }
        return null;
    }

    public Date getPredefinedPeriodEndDate(PredefinedReportingPeriodsEnum predefinedPeriod) {
        for (Map.Entry<String, List<Date>> entry : predefinedReportingPeriodsMap.entrySet()) {
            String key = entry.getKey();
            if (key.equalsIgnoreCase(predefinedPeriod.toString())) {
                return entry.getValue().get(1);
            }
        }
        return null;
    }

    public Date getCurrentDate() {

        // get today and clear time of day
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);

        Date currentDate = cal.getTime();
        return currentDate;
    }

    public Date getCurrentWeekStart() {

        // get today and clear time of day
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);

        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());

        Date currentWeekStart = cal.getTime();

        return currentWeekStart;
    }

    public Date getPreviousWeekStart() {

        // get today and clear time of day
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);

        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        cal.add(Calendar.DATE, -7);
        Date previousWeekStart = cal.getTime();

        return previousWeekStart;
    }

    public Date getPreviousWeekEnd() {

        // get today and clear time of day
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0); // ! clear would not reset the hour of day !
        cal.clear(Calendar.MINUTE);
        cal.clear(Calendar.SECOND);
        cal.clear(Calendar.MILLISECOND);

        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek());
        cal.add(Calendar.DATE, -1);
        Date previousWeekEnd = cal.getTime();

        return previousWeekEnd;
    }

    public Date getCurrentMonthStart() {

        Calendar cal = Calendar.getInstance();   // this takes current date
        cal.set(Calendar.DAY_OF_MONTH, 1);
        Date currentMonthStart = cal.getTime();

        return currentMonthStart;
    }


//    public int getTotalNumberOfTeamMembers(String projectName) {
//
//        int counter = 0;
//        for (User user : UserData.userList) {
////            if (user().equalsIgnoreCase(projectName)) {
//                counter++;
//            }
//        }
//        return counter;
//    }

    public int getTotalNumberOfTeamMembers(String projectName, Date fromDate, Date toDate) {

        int counter = 0;
        for (User user : UserData.userList) {
            if (user.getProject().getProjectName().equalsIgnoreCase(projectName) && user.getEmploymentDate().before(fromDate) && !user.getEmploymentDate().after(toDate)) {
                counter++;
            }
        }
        return counter;
    }









    public int getTotalNumberOfTeamMembers(String projectName, PredefinedReportingPeriodsEnum predefinedPeriod) {

        return getTotalNumberOfTeamMembers(projectName, getPredefinedPeriodStartDate(predefinedPeriod), getPredefinedPeriodEndDate(predefinedPeriod));
    }

    public int getNumberOfTeamMembersWithFeedbackSent(String projectName) {

        int counter = 0;
        Set uniqueUsers = new HashSet();

        for (User user : UserData.userList) {
            if (user.getProject().getProjectName().equalsIgnoreCase(projectName)) {

                for (Mood mood : MoodData.moodList) {
                    if (mood.getUser().getId().equals(user.getId())) {  // to replace user.getUserName with user.getID
                        uniqueUsers.add(user);
                    }
                }
            }
        }
        return uniqueUsers.size();
    }

    public static int getNumberOfTeamMembersWithFeedbackSent(String projectName, Date fromDate, Date toDate) {

        int counter = 0;
        Set uniqueUsers = new HashSet();

        for (User user : UserData.userList) {
            if (user.getProject().getProjectName().equalsIgnoreCase(projectName)) {

                for (Mood mood : MoodData.moodList) {
                    if (mood.getUser().getId() == user.getId() && !mood.getDate().before(fromDate) && !mood.getDate().after(toDate)) {
                        uniqueUsers.add(user);
                    }
                }
            }
        }
        return uniqueUsers.size();
    }

    public int getNumberOfTeamMembersWithFeedbackSent(String projectName, PredefinedReportingPeriodsEnum predefinedPeriod) {

        return getNumberOfTeamMembersWithFeedbackSent(projectName, getPredefinedPeriodStartDate(predefinedPeriod), getPredefinedPeriodEndDate(predefinedPeriod));
    }

    public double getAverageRatingForUser(Long userId) {
        int countMoodSubmissions = 0;
        int ratingAcc = 0;
        double result = 0;

        for (Mood mood : MoodData.moodList) {
            if (mood.getUser().getId() == userId) {
                countMoodSubmissions++;
                ratingAcc = ratingAcc + mood.getDayRating();
            }
        }
        result = Double.parseDouble(df2.format((double) ratingAcc / countMoodSubmissions));
        return result;
    }

    public double getAverageRatingForUser(Long userId, Date fromDate, Date toDate) {
        int countMoodSubmissions = 0;
        int ratingAcc = 0;
        double result = 0;

        for (Mood mood : MoodData.moodList) {
            if (mood.getUser().getId() == userId && !mood.getDate().before(fromDate) && !mood.getDate().after(toDate)) {
                countMoodSubmissions++;
                ratingAcc = ratingAcc + mood.getDayRating();
            }
        }
        result = Double.parseDouble(df2.format((double) ratingAcc / countMoodSubmissions));
        return result;
    }

    public double getAverageRatingForUser(Long userId, PredefinedReportingPeriodsEnum predefinedPeriod) {
        return getAverageRatingForUser(userId, getPredefinedPeriodStartDate(predefinedPeriod), getPredefinedPeriodEndDate(predefinedPeriod));
    }

    public int getNumberOfMoodSubmissionsByProject(String projectName) {

        int counter = 0;

        for (User user : UserData.userList) {
            if (user.getProject().getProjectName().equalsIgnoreCase(projectName)) {
                for (Mood mood : MoodData.moodList) {
                    if (mood.getUser().getId() == user.getId()) {
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
            if (user.getProject().getProjectName().equalsIgnoreCase(projectName)) {
                for (Mood mood : MoodData.moodList) {
                    if (mood.getUser().getId() == user.getId() && !mood.getDate().before(fromDate) && !mood.getDate().after(toDate)) {
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public int getNumberOfMoodSubmissionsByProject(String projectName, PredefinedReportingPeriodsEnum predefinedPeriod) {
        return getNumberOfMoodSubmissionsByProject(projectName, getPredefinedPeriodStartDate(predefinedPeriod), getPredefinedPeriodEndDate(predefinedPeriod));
    }

    public int getTotalRatingValueForSubmissionsByProject(String projectName) {

        int totalRatingAcc = 0;

        for (User user : UserData.userList) {
            if (user.getProject().getProjectName().equalsIgnoreCase(projectName)) {
                for (Mood mood : MoodData.moodList) {
                    if (mood.getUser().getId() == user.getId()) {
                        totalRatingAcc = totalRatingAcc + mood.getDayRating();
                    }
                }
            }
        }
        return totalRatingAcc;
    }

    public int getTotalRatingValueForSubmissionsByProject(String projectName, Date fromDate, Date toDate) {

        int totalRatingAcc = 0;

        for (User user : UserData.userList) {
            if (user.getProject().getProjectName().equalsIgnoreCase(projectName)) {
                for (Mood mood : MoodData.moodList) {
                    if (mood.getUser().getId() == user.getId() && !mood.getDate().before(fromDate) && !mood.getDate().after(toDate)) {
                        totalRatingAcc = totalRatingAcc + mood.getDayRating();
                    }
                }
            }
        }
        return totalRatingAcc;
    }

    public int getTotalRatingValueForSubmissionsByProject(String projectName, PredefinedReportingPeriodsEnum predefinedPeriod) {
        return getTotalRatingValueForSubmissionsByProject(projectName, getPredefinedPeriodStartDate(predefinedPeriod), getPredefinedPeriodEndDate(predefinedPeriod));
    }

    public Long getManagerByProject(String projectName) {

        for (Project project : ProjectData.projectList) {
            if (project.getProjectName().equalsIgnoreCase(projectName)) {
//                return project.getUser().getId();
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

    public Double getAverageMoodRatingForProject(String projectName, PredefinedReportingPeriodsEnum predefinedPeriod) {
        return getAverageMoodRatingForProject(projectName, getPredefinedPeriodStartDate(predefinedPeriod), getPredefinedPeriodEndDate(predefinedPeriod));
    }
}

