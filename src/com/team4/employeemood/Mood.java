package com.team4.employeemood;

import java.util.Date;

public class Mood {
    Integer dayRating;
    String comment;
    String previousDayChange;
    String improvementIdea;
    Date date;
    String username;

    public Mood(Integer dayRating, String comment, String previousDayChange, String improvementIdea, Date date, String username) {
        this.dayRating = dayRating;
        this.comment = comment;
        this.previousDayChange = previousDayChange;
        this.improvementIdea = improvementIdea;
        this.date = date;
        this.username = username;
    }

    public Integer getDayRating() {
        return dayRating;
    }

    public String getComment() {
        return comment;
    }

    public String getPreviousDayChange() {
        return previousDayChange;
    }

    public String getImprovementIdea() {
        return improvementIdea;
    }

    public Date getDate() {
        return date;
    }

    public String getUsername() {
        return username;
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
