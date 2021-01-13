package com.team4.employeemood.service;

import com.team4.employeemood.repository.MoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoodService {

    @Autowired
    MoodRepository moodRepository;




}
