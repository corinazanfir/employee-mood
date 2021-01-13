package com.team4.employeemood.service;

import com.team4.employeemood.Project;
import com.team4.employeemood.controller.representation.TeamAverageReportRepresentation;
import com.team4.employeemood.repository.ProjectRepository;
import com.team4.employeemood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReportService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserService userService;


    public TeamAverageReportRepresentation generateTeamAverageReport(Long projectId, Date startDate, Date endDate) {

        TeamAverageReportRepresentation report = new TeamAverageReportRepresentation();

        report.setStartDate(startDate);
        report.setEndDate(endDate);
        Project project = projectRepository.findById(projectId).get();
        report.setProjectManager(project.getProjectManager().getFullName());

        Integer noUsers = userService.getListOfUsersAssignedToProjectBetweenDates(projectId, startDate, endDate).size();
        report.setNoUsers(noUsers);

        //TODO average rating
        //TODO noSubmissions
        //TODO noUsersFeedbackSubmitted

        return report;
    }
}
