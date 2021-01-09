package com.team4.employeemood;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name="users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;
    private Date birthdate;
    private Date employmentDate;
//    private String projectName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="project_id")
    private Project project;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Mood> moods = new ArrayList<>();

//    private String username;

    public User(String firstName, String lastName, Date birthDate, Date employmentDate, String projectName, Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthdate = birthdate;
        this.employmentDate = employmentDate;
//        this.projectName = projectName;
//        this.username = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@moodproject";
        this.id = this.id;

        UserData.userList.add(this);
    }

    public User() {
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
        return birthdate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthdate = birthDate;
    }

    public Date getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(Date employmentDate) {
        this.employmentDate = employmentDate;
    }

//    public String getProjectName() {
//        return projectName;
//    }
//
//    public void setProjectName(String projectName) {
//        this.projectName = projectName;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public List<Mood> getMoods() {
        return moods;
    }

    public void setMoods(List<Mood> moods) {
        this.moods = moods;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}