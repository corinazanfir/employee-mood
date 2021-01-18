package com.team4.employeemood.repository;

import com.team4.employeemood.model.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {

    List<Mood> findByUserId(Long userId);

    List<Mood> findByUserIdIn(List<Long> userIds);

    List<Mood> findByUserIdInAndDateBetween(List<Long> userIds, Date startDate, Date endDate);


}
