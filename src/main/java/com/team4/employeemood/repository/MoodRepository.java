package com.team4.employeemood.repository;

import com.team4.employeemood.model.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Integer> {

    List<Mood> findByUserId(Long userId);

    List<Mood> findByUserIdIn(List<Integer> userIds);

    List<Mood> findByUserIdInAndDateBetween(List<Integer> userIds, Date startDate, Date endDate);


}
