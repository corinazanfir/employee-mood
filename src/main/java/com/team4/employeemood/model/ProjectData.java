package com.team4.employeemood.model;

import java.util.ArrayList;
import java.util.List;

public class ProjectData {
    public static List<Project> projectList = new ArrayList<>();  //temporary solution to keep a list of loaded instances from file

    public void displayList() {

        for (Project project : projectList) {
            System.out.println(project);
        }
    }
}


