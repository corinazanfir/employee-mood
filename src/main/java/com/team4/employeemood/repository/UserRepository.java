package com.team4.employeemood.repository;

import com.team4.employeemood.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByFirstName(String firstName);

    List<User> findAllByBirthdate(Date birthdate);

//    @Query("Select * from User where employmentDate > $1")
//    List<User> findAfterEmploymentDate(Date employmentDate);


}
