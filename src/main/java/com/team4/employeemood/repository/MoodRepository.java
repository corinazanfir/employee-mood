package com.team4.employeemood.repository;

import com.team4.employeemood.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoodRepository extends JpaRepository<Mood,Long> {

    List<Mood> findByUserId(Long userId);
    List<Mood> findByUserIdIn(List<Long> userIds);


}
