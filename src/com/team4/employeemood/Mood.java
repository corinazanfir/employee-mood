package com.team4.employeemood;

import com.team4.employeemood.exceptions.MoodConstructException;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mood {

    Integer dayRating;
    String comment;
    String previousDayChange;
    String improvementIdea;
    Date date;
    String username;
    //"|" separator for CSV file

    public Mood(Integer dayRating, String comment, String previousDayChange, String improvementIdea, Date date, String username) {
        this.dayRating = dayRating;
        this.comment = comment;
        this.previousDayChange = previousDayChange;
        this.improvementIdea = improvementIdea;
        this.date = date;
        this.username = username;

        MoodData.moodList.add(this);
    }

    public Mood(String MoodDetails) throws MoodConstructException {

        Pattern pattern = Pattern.compile("(.*?)|(.*?)|(.*?)|(.*?)|(.*?)|(.*?)");
        Matcher matcher = pattern.matcher(MoodDetails);

        if (matcher.find()) {
            this.dayRating = 10;//Integer.parseInt(matcher.group(1));
            this.comment = matcher.group(2);
            this.previousDayChange = matcher.group(3);
            this.improvementIdea = matcher.group(4);
            //this.date = matcher.group(5);
            this.username = matcher.group(6);
        } else {
            throw new MoodConstructException("Mood not properly defined.");
        }
    }

    @Override
    public String toString() {
        return "Mood{" +
                "dayRating=" + dayRating +
                ", comment='" + comment + '\'' +
                ", previousDayChange='" + previousDayChange + '\'' +
                ", improvementIdea='" + improvementIdea + '\'' +
                ", date=" + date +
                ", username='" + username + '\'' +
                '}';
    }
}
