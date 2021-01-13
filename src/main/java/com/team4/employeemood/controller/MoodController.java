package com.team4.employeemood.controller;

import com.team4.employeemood.Mood;
import com.team4.employeemood.User;
import com.team4.employeemood.repository.MoodRepository;
import com.team4.employeemood.repository.UserRepository;
import javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MoodController {

    @Autowired
    private MoodRepository moodRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/v1/moods")
    @ResponseBody
    public List<Mood> getMoodsForProjectBetweenDates(@RequestParam Long projectId, @RequestParam String startDate, @RequestParam String endDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<User> byProjectIdAndEmploymentDateBetween = userRepository.findByProjectIdAndEmploymentDateBetween(projectId, sdf.parse(startDate), sdf.parse(endDate));
        System.out.println(byProjectIdAndEmploymentDateBetween);

        List<Long> userIdsForProjectForDates = byProjectIdAndEmploymentDateBetween.stream().map(user -> user.getId()).collect(Collectors.toList());
        System.out.println(userIdsForProjectForDates);

        return moodRepository.findByUserIdIn(userIdsForProjectForDates);
    }
}