package com.example.practice.repository;

import com.example.practice.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, String> {
    @Query(value = "select * from job order by ", nativeQuery = true)
    List<Job> findAllByOrderByLocation();

    @Query(value = "select * from job where min_salary <= ?1 and max_salary >= ?1 ", nativeQuery = true)
    List<Job> findBySalaryRange(int salary);

    List<Job> findByTitleContainsOrDescriptionContains(String title, String description);

    @Query(value = "select * from job where location =?1 and (title like %?2%  or description like %?2%) ", nativeQuery = true)
    List<Job> findByLocationAndKeyword(String location, String keyword);
}
