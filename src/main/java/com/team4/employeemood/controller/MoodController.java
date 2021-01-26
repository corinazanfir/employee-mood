package com.team4.employeemood.controller;

import com.team4.employeemood.model.Mood;
import com.team4.employeemood.model.User;
import com.team4.employeemood.repository.MoodRepository;
import com.team4.employeemood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MoodController {

    @Autowired
    private MoodRepository moodRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/v1/moods")
    public String getAllMoods(Model model) {
        List<Mood> moods = moodRepository.findAll();
        model.addAttribute("moods", moods);
        return "moods";
    }

    @GetMapping("/api/v1/moods/{projectId}")
    public String getAllMoodsForProject(@PathVariable Integer projectId, Model model) {
        List<User> byProjectId = userRepository.findAllByProjectId(projectId);
        List<Integer> userIdsForProjectForDates = byProjectId.stream().map(user -> user.getId()).collect(Collectors.toList());
        model.addAttribute("moods", moodRepository.findByUserIdIn(userIdsForProjectForDates));
        return "moods";
    }

    @GetMapping("/api/v1/moods/{projectId}/{startDate}/{endDate}")
    @ResponseBody
    public List<Mood> getMoodsForProjectBetweenDates(@PathVariable Integer projectId, @PathVariable String startDate, @PathVariable String endDate) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        List<User> byProjectIdAndEmploymentDateBetween = userRepository.findByProjectIdAndEmploymentDateBetween(projectId, sdf.parse(startDate), sdf.parse(endDate));
        System.out.println(byProjectIdAndEmploymentDateBetween);

        List<Integer> userIdsForProjectForDates = byProjectIdAndEmploymentDateBetween.stream().map(user -> user.getId()).collect(Collectors.toList());
        System.out.println(userIdsForProjectForDates);

        return moodRepository.findByUserIdIn(userIdsForProjectForDates);
    }

    @GetMapping("/moodForm")
    public String getMoodForm() {
        return "moodForm";
    }

    @PostMapping("/moodForm")
    public String addMood(Mood mood) {

        System.out.println("Received Mood: " + mood);
        //TODO - form validation backend/frontend ???
        mood.setDate(new Date());

        //hardcoded user - no login available
        mood.setUser(userRepository.findById(1).get());

        mood = moodRepository.save(mood);
        System.out.println("Persisted mood: " + mood);

        return "redirect:/";
    }
}
