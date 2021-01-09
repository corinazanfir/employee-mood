package com.team4.employeemood;

import javax.persistence.*;
import java.util.*;


@Entity(name="projects")
public class Project {

    @Id
    @GeneratedValue
    private Long id;

    private String projectName;
    private Integer projectBudget;
    private Date projectDueDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="project_manager_id")
    private User user;

//    private String projectManager;

    public Project(String projectName, int projectBudget, Date projectDueDate, String projectManager, Long id) {
        this.projectName = projectName;
        this.projectBudget = projectBudget;
        this.projectDueDate = projectDueDate;
//        this.projectManager = projectManager;
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

//    public String getProjectManager() {
//        return projectManager;
//    }

//    public void setProjectManager(String projectManager) {
//        this.projectManager = projectManager;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProjectBudget(Integer projectBudget) {
        this.projectBudget = projectBudget;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

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
}
