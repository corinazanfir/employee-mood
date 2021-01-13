package com.team4.employeemood.controller.representation;

import java.util.Date;

public class TeamAverageReportRepresentation {
    private final String name = "Team Average Mood Report";
    private Date startDate;
    private Date endDate;
    private Double averageRating;
    private Integer noUsers;
    private Integer noUsersFeedbackSubmitted;
    private Integer noSubmissions;
    private String projectManager;

    public TeamAverageReportRepresentation(Date startDate, Date endDate, Double averageRating, Integer noUsers, Integer noUsersFeedbackSubmitted, Integer noSubmissions, String projectManager) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.averageRating = averageRating;
        this.noUsers = noUsers;
        this.noUsersFeedbackSubmitted = noUsersFeedbackSubmitted;
        this.noSubmissions = noSubmissions;
        this.projectManager = projectManager;
    }

    public TeamAverageReportRepresentation() {
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Integer getNoUsers() {
        return noUsers;
    }

    public void setNoUsers(Integer noUsers) {
        this.noUsers = noUsers;
    }

    public Integer getNoUsersFeedbackSubmitted() {
        return noUsersFeedbackSubmitted;
    }

    public void setNoUsersFeedbackSubmitted(Integer noUsersFeedbackSubmitted) {
        this.noUsersFeedbackSubmitted = noUsersFeedbackSubmitted;
    }

    public Integer getNoSubmissions() {
        return noSubmissions;
    }

    public void setNoSubmissions(Integer noSubmissions) {
        this.noSubmissions = noSubmissions;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getName() {
        return name;
    }
}
