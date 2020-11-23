package com.team4.employeemood;

import java.util.Date;
import java.util.List;

public class Employee {

    String firstName;
    String lastName;
    Date birthday;
    Date hireDate;
    String username;
    List<Project> assignedProjects;
    List<Employee> directReports;

    public Employee(String firstName, String lastName, Date birthday, Date hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.hireDate = hireDate;
        this.username = (firstName + "." + lastName + "@domain.com").toLowerCase();//new StringBuffer().append(firstName).append(".").append(lastName).append("@db.com")
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", hireDate=" + hireDate +
                ", username='" + username + '\'' +
                ", assignedProjects=" + assignedProjects +
                ", directReports=" + directReports +
                '}';
    }
}
