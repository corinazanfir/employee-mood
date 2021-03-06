package com.team4.employeemood.controller.representation;


import com.team4.employeemood.model.Project;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TopMoodProjectsReportRepresentation {
    private final String name = "Top Mood Projects Report";
    private Date startDate;
    private Date endDate;
    Map<Project, Double> topMoodProjects = new HashMap<>();


    public TopMoodProjectsReportRepresentation() {
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

    public Map<Project, Double> getTopMoodProjects() {
        return topMoodProjects;
    }

    public void setTopMoodProjects(Map<Project, Double> topMoodProjects) {
        this.topMoodProjects = topMoodProjects;
    }

    public String getName() {
        return name;
    }

}
