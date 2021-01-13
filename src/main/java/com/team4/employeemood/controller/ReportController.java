package com.team4.employeemood.controller;

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

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    // Sample to test - localhost:8080/api/v1/reports/teamAverage?projectId=1&startDate=2018-01-01&endDate=2021-01-15

    @GetMapping("/api/v1/reports/teamAverage")
    public TeamAverageReportRepresentation generateTeamAverage(@RequestParam Long projectId, @RequestParam String startDate, @RequestParam String endDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return reportService.generateTeamAverageReport(projectId, sdf.parse(startDate), sdf.parse(endDate));
    }

}
