package com.example.practice.service;

import com.example.practice.entity.Job;

import java.util.List;

public interface JobService {

    List<Job> getAllJobsSortByLocation();

    List<Job> getAllJobs();

    List<Job> getJobsBySalaryRange(Integer salary);

    List<Job> getJobsByKeyWord(String keyword);

    List<Job> getJobsByLocationAndKeyword(String location, String keyword);
}
