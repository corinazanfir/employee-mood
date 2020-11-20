package com.team4.employeemood;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Employee {

    String firstName;
    String lastName;
    Date birthday;
    Date hireDate;
    String username;
    List<Project> assignedProjects;
    List<Employee> directReports;
    Map<String,Mood> dateMoodMap = new HashMap<>();

    public Employee(String firstName, String lastName, Date birthday, Date hireDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.hireDate = hireDate;
    }
}
