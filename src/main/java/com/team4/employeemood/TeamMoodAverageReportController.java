package com.team4.employeemood;

import com.team4.employeemood.Reports.ReportUtil;
import com.team4.employeemood.Reports.TeamAverageReport;
import javassist.Loader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class TeamMoodAverageReportController {

    @GetMapping("/api/v1/TeamAverageReport")
    @ResponseBody
    @ResponseStatus()
    public String teamAverageReport(@RequestParam String projectName, @RequestParam String fromDate, @RequestParam String toDate) throws IOException, ParseException {
        TeamAverageReport teamAverageReport = new TeamAverageReport();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Date fromDateParsed = sdf.parse(fromDate);
        Date toDateParsed = sdf.parse(toDate);

        List<String> reportLines = teamAverageReport.generateReport(projectName, false, false, fromDateParsed, toDateParsed); //ReportUtil.PredefinedReportingPeriodsEnum.CurrentMonth);

        StringBuffer stringBuffer = new StringBuffer();
        reportLines.forEach(line -> stringBuffer.append(line + "</br>"));

        return stringBuffer.toString();
    }
}
