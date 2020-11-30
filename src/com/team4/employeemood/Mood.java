package com.team4.employeemood;

import com.team4.employeemood.exceptions.MoodConstructException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mood {

    private Integer dayRating;
    private String comment;
    private String previousDayChange;
    private String improvementIdea;
    private Date date;
    private String username;

    public Mood(Integer dayRating, String comment, String previousDayChange, String improvementIdea, Date date, String username) {
        this.dayRating = dayRating;
        this.comment = comment;
        this.previousDayChange = previousDayChange;
        this.improvementIdea = improvementIdea;
        this.date = date;
        this.username = username;

        MoodData.moodList.add(this);
    }

    public Mood(String MoodDetails) throws MoodConstructException, ParseException {

        Pattern pattern = Pattern.compile("(.*);(.*);(.*?);(.*?);(([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9]?[0-9][0-9]));(.*)");
        Matcher matcher = pattern.matcher(MoodDetails);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        if (matcher.find()) {
            this.dayRating = Integer.parseInt(matcher.group(1));
            this.comment = matcher.group(2);
            this.previousDayChange = matcher.group(3);
            this.improvementIdea = matcher.group(4);
            this.date = new SimpleDateFormat("dd/MM/yyyy").parse(matcher.group(5));
            this.username = matcher.group(9);
        } else {
            throw new MoodConstructException("Mood not properly defined. Certain field are not using the expected format.");
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
