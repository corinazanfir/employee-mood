package com.team4.employeemood;

public class User {
    private String firstName;
    private String lastName;
    private String birthDate;
    private String employmentDate;
    private String projectName;

    public User(String firstName, String lastName, String birthDate, String employmentDate, String projectName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.employmentDate = employmentDate;
        this.projectName = projectName;
    }

    public User(String userDetails){
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(String employmentDate) {
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
