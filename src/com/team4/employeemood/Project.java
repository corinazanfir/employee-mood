package com.team4.employeemood;

import java.util.*;

public class Project {
    String projectName;
    int projectBudget;
    Date projectDueDate;
    String projectManager;

    public Project(String projectName, int projectBudget, Date projectDueDate, String projectManager) {
        this.projectName = projectName;
        this.projectBudget = projectBudget;
        this.projectDueDate = projectDueDate;
        this.projectManager = projectManager;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getProjectBudget() {
        return projectBudget;
    }

    public void setProjectBudget(int projectBudget) {
        this.projectBudget = projectBudget;
    }

    public Date getProjectDueDate() {
        return projectDueDate;
    }

    public void setProjectDueDate(Date projectDueDate) {
        this.projectDueDate = projectDueDate;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }
}
