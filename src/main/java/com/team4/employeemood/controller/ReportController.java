package com.team4.employeemood.controller;

import com.team4.employeemood.controller.representation.TeamAverageReportRepresentation;
import com.team4.employeemood.controller.representation.TopMoodProjectsReportRepresentation;
import com.team4.employeemood.service.EmailService;
import com.team4.employeemood.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@RestController
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private EmailService emailService;

    // Sample to test - localhost:8080/api/v1/reports/teamAverage?projectId=1&startDate=2018-01-01&endDate=2021-01-15
    // Sample to test - localhost:8080/api/v1/reports/teamAverage?projectId=1&startDate=2018-01-01&endDate=2021-01-15&sendEmail=true&toEmailAddress=catalingheorghe111@gmail.com
    @GetMapping("/api/v1/reports/teamAverage")
    public TeamAverageReportRepresentation generateTeamAverage(@RequestParam Integer projectId,
                                                               @RequestParam String startDate,
                                                               @RequestParam String endDate,
                                                               @RequestParam(required = false) boolean sendEmail,
                                                               @RequestParam(required = false) String toEmailAddress) throws ParseException, MessagingException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        TeamAverageReportRepresentation report = reportService.generateTeamAverageReport(projectId, sdf.parse(startDate), sdf.parse(endDate));
        if (sendEmail && !toEmailAddress.isEmpty()) {
            emailService.sendSimpleMessage(toEmailAddress, report.getName() , "This is an automatically generated email.");
         //TODO generate report as file so it can be attached to the email
            emailService.sendMessageWithAttachment(toEmailAddress, report.getName(), "This is an automatically generated email.","TestFile.txt","myAttachmentFile.txt");
        }

        return report;
    }



    //Sample to test - localhost:8080/api/v1/reports/topMood?startDate=2018-01-01&endDate=2021-02-01
    //Sample to test - localhost:8080/api/v1/reports/topMood?startDate=2018-01-01&endDate=2021-02-01&sendEmail=true&toEmailAddress=catalingheorghe111@gmail.com
    @GetMapping("/api/v1/reports/topMood")
    public TopMoodProjectsReportRepresentation generateTopMood(@RequestParam String startDate,
                                                               @RequestParam String endDate,
                                                               @RequestParam(required = false) boolean sendEmail,
                                                               @RequestParam(required = false) String toEmailAddress) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        TopMoodProjectsReportRepresentation report = reportService.generateTopMoodProjectsReport(sdf.parse(startDate), sdf.parse(endDate));

        if (sendEmail && !toEmailAddress.isEmpty()) {
            emailService.sendSimpleMessage(toEmailAddress, report.getName() , "This is an automatically generated email.");
        }
        return report;

    }

//    @GetMapping('/moods')
//    public MoodData getMoods() {
//
//    }
}
