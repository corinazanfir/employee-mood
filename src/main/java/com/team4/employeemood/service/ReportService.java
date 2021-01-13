package com.team4.employeemood.service;

import com.team4.employeemood.Mood;
import com.team4.employeemood.Project;
import com.team4.employeemood.controller.representation.TeamAverageReportRepresentation;
import com.team4.employeemood.repository.MoodRepository;
import com.team4.employeemood.repository.ProjectRepository;
import com.team4.employeemood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MoodRepository moodRepository;

    public TeamAverageReportRepresentation generateTeamAverageReport(Long projectId, Date startDate, Date endDate) {

        TeamAverageReportRepresentation report = new TeamAverageReportRepresentation();

        report.setStartDate(startDate);
        report.setEndDate(endDate);
        Project project = projectRepository.findById(projectId).get();
        report.setProjectManager(project.getProjectManager().getFullName());

        List<Long> listOfUsersAssignedToProjectBetweenDates = userService.getListOfUsersAssignedToProjectBetweenDates(projectId, startDate, endDate);

        report.setNoUsers(listOfUsersAssignedToProjectBetweenDates.size());

        //Calculate average mood rating
        List<Mood> filteredMoodsByUserAndDates = moodRepository.findByUserIdInAndDateBetween(listOfUsersAssignedToProjectBetweenDates, startDate, endDate);

        Double averageRating = filteredMoodsByUserAndDates.stream()
                .mapToDouble(Mood::getDayRating)
                .average().orElse(0);

        report.setAverageRating(averageRating);

        //calculate number of submissions for a given project between given dates
        Integer noSubmissions = filteredMoodsByUserAndDates.size();
        report.setNoSubmissions(noSubmissions);

        //Calculate the number of distinct users that have submitted feedback for the respective project and between dates.
        Integer noUserFeedbackSubmitted = Math.toIntExact(filteredMoodsByUserAndDates.stream()
                .mapToInt(mood -> Math.toIntExact(mood.getUser().getId()))
                .distinct()
                .count());

        report.setNoUsersFeedbackSubmitted(noUserFeedbackSubmitted);

        return report;
    }
}
