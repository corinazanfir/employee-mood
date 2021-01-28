package com.team4.employeemood.controller;

import com.team4.employeemood.controller.representation.TeamAverageReportRepresentation;
import com.team4.employeemood.controller.representation.TopMoodProjectsReportRepresentation;
import com.team4.employeemood.model.Mail;
import com.team4.employeemood.service.EmailSenderService;
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
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;

    //old one
    @Autowired
    private EmailService emailService;
    //for thymeleaf template
    @Autowired
    private EmailSenderService emailSenderService;

    @GetMapping("/reports")
    public String getReports() {
        return "reports";
    }

    @GetMapping("/reports/teamAverage")
    public String TeamAverageReport(@RequestParam(required = false) Integer projectId,
                                    @RequestParam(required = false) String startDate,
                                    @RequestParam(required = false) String endDate,
                                    @RequestParam(required = false) String sendEmail,
                                    Model model) throws ParseException, MessagingException, IOException {

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

            Map<String, Object> properties = new HashMap<String, Object>();
            properties.put("projectName", report.getProjectName());
            properties.put("startDate", report.getStartDate());
            properties.put("endDate", report.getEndDate());
            properties.put("averageRating", report.getAverageRating());
            properties.put("noUsers", report.getNoUsers());
            properties.put("noUsersFeedbackSubmitted", report.getNoUsersFeedbackSubmitted());
            properties.put("projectManager", report.getProjectManager());
            properties.put("noSubmissions", report.getNoSubmissions());

            Mail mail = Mail.builder()
                    .from("catalingheorghe111@gmail.com")
                    .to("catalingheorghe111@gmail.com")
                    .htmlTemplate(new Mail.HtmlTemplate("teamAverageReportResultsMail", properties))
                    .subject(report.getName() + " from " +
                            sdf.format(report.getStartDate()) + " to " +
                            sdf.format(report.getEndDate()))
                    .build();

            emailSenderService.sendEmail(mail);

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
