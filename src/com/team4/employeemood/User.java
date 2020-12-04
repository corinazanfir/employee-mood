package com.team4.employeemood;

import com.team4.employeemood.exceptions.PatternNotMatchingException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

        UserData.userList.add(this);
    }

    public User(){
        //TO DO
    };

    public User(String userDetails) throws PatternNotMatchingException, ParseException {

        Pattern pattern = Pattern.compile("(.*);(.*);(([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9]?[0-9][0-9]));(([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9]?[0-9][0-9]));(.*)");
        Matcher matcher = pattern.matcher(userDetails);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        if (matcher.find()) {
            this.firstName = matcher.group(1);
            this.lastName = matcher.group(2);
            this.birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(matcher.group(3));
            this.employmentDate = new SimpleDateFormat("dd/MM/yyyy").parse(matcher.group(7));
            this.projectName = matcher.group(11);
        } else {
            throw new PatternNotMatchingException("User not properly defined. Certain fields are not using the expected format.\nRejected record is: " + userDetails);
        }
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
