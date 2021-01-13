package com.team4.employeemood.controller;

import com.team4.employeemood.Mood;
import com.team4.employeemood.controller.representation.TeamAverageReportRepresentation;
import com.team4.employeemood.repository.MoodRepository;
import com.team4.employeemood.service.ReportService;
import com.team4.employeemood.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class ReportController {
    @Autowired
    private UserService userService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private MoodRepository moodRepository;

    @GetMapping("/api/v1/reports/users")
    public Integer getNumberOfEmployeesAssignedToProjectBetweenDates(@RequestParam Long projectId, @RequestParam String startDate, @RequestParam String endDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return userService.getListOfUsersAssignedToProjectBetweenDates(projectId, sdf.parse(startDate), sdf.parse(endDate)).size();
    }

    @GetMapping("/api/v1/reports/moodsForUsers")
    public List<Mood> getMoodsForUsers(@RequestParam Long projectId, @RequestParam String startDate, @RequestParam String endDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<Long> totalNumberOfTeamMembers = userService.getListOfUsersAssignedToProjectBetweenDates(projectId, sdf.parse(startDate), sdf.parse(endDate));
        return moodRepository.findByUserIdIn(totalNumberOfTeamMembers);

    }

    @GetMapping("/api/v1/reports/teamAverage")
    public TeamAverageReportRepresentation generateTeamAverage(@RequestParam Long projectId, @RequestParam String startDate, @RequestParam String endDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return reportService.generateTeamAverageReport(projectId, sdf.parse(startDate), sdf.parse(endDate));
    }

}
