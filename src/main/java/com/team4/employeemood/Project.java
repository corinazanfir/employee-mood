package com.team4.employeemood;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.*;


@Entity
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String projectName;
    private Integer projectBudget;
    private Date projectDueDate;
    private String projectManager;

    public Project(String projectName, int projectBudget, Date projectDueDate, String projectManager, Long id) {
        this.projectName = projectName;
        this.projectBudget = projectBudget;
        this.projectDueDate = projectDueDate;
        this.projectManager = projectManager;
        this.id = id;
    }

    public Project() {
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

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", projectBudget=" + projectBudget +
                ", projectDueDate=" + projectDueDate +
                ", projectManager='" + projectManager + '\'' +
                '}';
    }
}
