package com.team4.employeemood;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping
    @ResponseBody
    public String home() {
        return "<div style=\"" +
                "padding:20px;" +
                "text-align:center;" +
                "background: #1abc9c;" +
                "color:white;" +
                "font-size:20px;" +
                "font-family: Arial;\">" +
                "<h1>Employee Mood Project</h1></br>" +
                "</div>" +
                "<h4>Please select the desired report that you wish to generate<h4></br>" +
                "<table>" +
                "<tr>" +
                "<td>" +
                "<form action=\"/api/v1/TeamAverageReport\">\n" +
                "    <input type=\"submit\" value=\"Team Mood Average Report\" />\n" +
                "</form>" +
                "</td>" +
                "<td>" +
                "<form action=\"http://localhost:8080/hi2\">\n" +
                "    <input type=\"submit\" value=\"Happiest Projects Report\" />\n" +
                "</form>" +
                "</td></tr></table>";

    }
}
