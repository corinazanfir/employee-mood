package com.team4.employeemood.controller;

import com.team4.employeemood.Mood;
import com.team4.employeemood.repository.MoodRepository;
import javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class MoodController {

    @Autowired
    private MoodRepository moodRepository;

    @GetMapping("/api/v1/moods")
    @ResponseBody
    public List<Mood> getMood(@RequestParam(required = false) Long id) {

        if (id == null) {
            return moodRepository.findAll();
        }

        List<Mood> moods = new ArrayList<>();
        Optional<Mood> mood = Optional.of(moodRepository.findById(id).get());

        moods.add(mood.get());

        return moods;

    }
}
