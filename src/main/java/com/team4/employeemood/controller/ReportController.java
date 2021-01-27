package com.team4.employeemood.controller;

import com.team4.employeemood.controller.representation.TeamAverageReportRepresentation;
import com.team4.employeemood.controller.representation.TopMoodProjectsReportRepresentation;
import com.team4.employeemood.service.EmailService;
import com.team4.employeemood.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/reports")
    public String getReports() {
        return "reports";
    }

    // Sample to test - localhost:8080/reports/teamAverage?projectId=1&startDate=2018-01-01&endDate=2021-01-15
    // Sample to test - localhost:8080/reports/teamAverage?projectId=1&startDate=2018-01-01&endDate=2021-01-15&sendEmail=true&toEmailAddress=catalingheorghe111@gmail.com

    @GetMapping("/reports/teamAverage")
    public String getTeamAverageReportFilters() {
        return "teamAverageReport";
    }

    @GetMapping("/reports/teamAverage/{projectId}")

    public String generateTeamAverage(@PathVariable Integer projectId, Model model) throws ParseException, MessagingException {

        List<TeamAverageReportRepresentation> reportValues = new ArrayList<>();
        reportValues.add(reportService.generateTeamAverageReport(projectId));

        model.addAttribute("teamAverageReport", reportValues);

        return "teamAverageReportResults";
    }

    @GetMapping("/reports/teamAverage/{projectId}/{startDate}/{endDate}")

    public String generateTeamAverage(@PathVariable Integer projectId,
                                      @PathVariable String startDate,
                                      @PathVariable String endDate,
                                      Model model) throws ParseException, MessagingException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");


        List<TeamAverageReportRepresentation> reportValues = new ArrayList<>();
        reportValues.add(reportService.generateTeamAverageReport(projectId, sdf.parse(startDate), sdf.parse(endDate)));

        model.addAttribute("teamAverageReport", reportValues);

        return "teamAverageReportResults";
    }



    //TODO update topMood to return
    @GetMapping("/reports/topMood")
    public TopMoodProjectsReportRepresentation generateTopMood(@RequestParam String startDate,
                                                               @RequestParam String endDate,
                                                               @RequestParam(required = false) boolean sendEmail,
                                                               @RequestParam(required = false) String toEmailAddress) throws ParseException, MessagingException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        TopMoodProjectsReportRepresentation report = reportService.generateTopMoodProjectsReport(sdf.parse(startDate), sdf.parse(endDate));

        if (sendEmail && !toEmailAddress.isEmpty()) {
            emailService.sendMessageWithAttachment(toEmailAddress, report.getName(), "This is an automatically generated email.", "TestFile.txt", "myAttachmentFile.txt");
        }
        return report;

    }
}
