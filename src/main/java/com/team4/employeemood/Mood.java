package com.team4.employeemood;

import com.team4.employeemood.Exceptions.PatternNotMatchingException;

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

    public Mood() {
    }


    public Integer getDayRating() {
        return dayRating;
    }

    public void setDayRating(Integer dayRating) {
        this.dayRating = dayRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getPreviousDayChange() {
        return previousDayChange;
    }

    public void setPreviousDayChange(String previousDayChange) {
        this.previousDayChange = previousDayChange;
    }

    public String getImprovementIdea() {
        return improvementIdea;
    }

    public void setImprovementIdea(String improvementIdea) {
        this.improvementIdea = improvementIdea;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
