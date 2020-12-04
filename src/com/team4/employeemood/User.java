package com.team4.employeemood;

import java.util.Date;

public class User {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Date employmentDate;
    private String projectName;

    public User(String firstName, String lastName, Date birthDate, Date employmentDate, String projectName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.projectName = projectName;

    }

    public User(){
        //TO DO
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Users{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", employmentDate='" + employmentDate + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
