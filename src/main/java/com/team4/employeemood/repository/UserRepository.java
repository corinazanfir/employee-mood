package com.team4.employeemood.repository;

import com.team4.employeemood.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByFirstName(String firstName);
    List<User> findAllByBirthdate(Date birthdate);

    List<User> findAllByProjectId(Integer projectId);

    List<User> findByProjectIdAndEmploymentDateBetween(Integer projectId, Date startDate, Date endDate);

//    @Query("Select * from User where employmentDate > $1")
//    List<User> findAfterEmploymentDate(Date employmentDate);


}
