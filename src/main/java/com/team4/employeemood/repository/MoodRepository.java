package com.team4.employeemood.repository;

import com.team4.employeemood.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoodRepository extends JpaRepository<Mood,Long> {

}
