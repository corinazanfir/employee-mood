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
    public String TeamAverageReport(@RequestParam(required = false) Integer projectId,
                                    @RequestParam(required = false) String startDate,
                                    @RequestParam(required = false) String endDate,
                                    @RequestParam(required = false) String sendEmail,
                                    Model model) throws ParseException, MessagingException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<TeamAverageReportRepresentation> reportValues = new ArrayList<>();

        if (projectId == null)
            return "teamAverageReport";

        if (startDate != "" && endDate != "") {
            reportValues.add(reportService.generateTeamAverageReport(projectId, sdf.parse(startDate), sdf.parse(endDate)));
        } else if (startDate == "" && endDate != "") {
            reportValues.add(reportService.generateTeamAverageReport(projectId, null, sdf.parse(endDate)));
        } else if (endDate == "" && startDate != "") {
            reportValues.add(reportService.generateTeamAverageReport(projectId, sdf.parse(startDate), null));
        } else {
            reportValues.add(reportService.generateTeamAverageReport(projectId, null, null));
        }

        model.addAttribute("teamAverageReport", reportValues);


        TeamAverageReportRepresentation report = reportValues.get(0);

        if (sendEmail != null) {
            emailService.sendMessageWithAttachment("catalingheorghe111@gmail.com",
                    report.getName() + " from: " +
                            sdf.format(report.getStartDate()) + " to: " +
                            sdf.format(reportValues.get(0).getEndDate()),
                    "body");
        }

        return "teamAverageReportResults";

    }

    @GetMapping("/reports/topMood")
    public TopMoodProjectsReportRepresentation generateTopMood(@RequestParam String startDate,
                                                               @RequestParam String endDate,
                                                               @RequestParam(required = false) boolean sendEmail,
                                                               @RequestParam(required = false) String toEmailAddress) throws ParseException, MessagingException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        TopMoodProjectsReportRepresentation report = reportService.generateTopMoodProjectsReport(sdf.parse(startDate), sdf.parse(endDate));

        if (sendEmail && !toEmailAddress.isEmpty()) {
            emailService.sendMessageWithAttachment(toEmailAddress, report.getName(), "This is an automatically generated email.");
        }
        return report;

    }
}
