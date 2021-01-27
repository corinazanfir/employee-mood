package com.team4.employeemood.repository;

import com.team4.employeemood.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByFirstName(String firstName);
    List<User> findAllByBirthdate(Date birthdate);

    List<User> findAllByProjectId(Integer projectId);

    List<User> findByProjectIdAndEmploymentDateBetween(Integer projectId, Date startDate, Date endDate);

    List<User> findAllByFirstNameAndLastName (String firstName, String lastName);

    @Query(value = "SELECT * FROM USERS WHERE project_Id = ?1 and employment_Date <= ?2 and termination_Date >= ?3", nativeQuery = true)
    List<User> findHiredEmployeesDuringReportingPeriod(Integer projectId,Date startDate, Date endDate);


}
