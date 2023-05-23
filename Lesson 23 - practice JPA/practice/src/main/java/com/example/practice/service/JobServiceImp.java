package com.example.practice.service;

import com.example.practice.entity.Job;
import com.example.practice.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobServiceImp implements JobService{
    @Autowired
    JobRepository jobRepository;

    @Override
    public List<Job> getAllJobsSortByLocation() {
       return jobRepository.findAllByOrderByLocation();
    }

    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    @Override
    public List<Job> getJobsBySalaryRange(Integer salary) {
        return jobRepository.findBySalaryRange(salary);
    }

    @Override
    public List<Job> getJobsByKeyWord(String keyword) {
        return jobRepository.findByTitleContainsOrDescriptionContains(keyword,keyword);
    }
    @Override
    public List<Job> getJobsByLocationAndKeyword(String location, String keyword) {
        return jobRepository.findByLocationAndKeyword(location,keyword);
    }
}
