package com.team4.employeemood.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;


@Entity(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String projectName;
    private Integer projectBudget;
    private Date projectDueDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    @JoinColumn(name = "project_manager_id")
    private User projectManager;

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


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setProjectBudget(Integer projectBudget) {
        this.projectBudget = projectBudget;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectBudget=" + projectBudget +
                ", projectDueDate=" + projectDueDate +
//                ", user=" + user +
                '}';
    }

    public User getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(User projectManager) {
        this.projectManager = projectManager;
    }
}
