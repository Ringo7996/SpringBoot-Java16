package com.example.practice.controller;

import com.example.practice.entity.Job;
import com.example.practice.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    JobService jobService;

    @GetMapping()
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/sortbylocation")
    public List<Job> getAllJobsSortByLocation() {
        return jobService.getAllJobsSortByLocation();
    }

    @GetMapping("/salary/{salary}")
    public List<Job> getJobsBySalaryRange(@PathVariable Integer salary) {
        return jobService.getJobsBySalaryRange(salary);
    }

    @GetMapping("/keyword/{keyword}")
    public List<Job> getJobsByKeyword(@PathVariable String keyword) {
        return jobService.getJobsByKeyWord(keyword);
    }


    @GetMapping("/query")
    public List<Job> getJobsByLocationAndKeyword(@RequestParam(name = "location") String location, @RequestParam(name = "keyword") String keyword) {
        return jobService.getJobsByLocationAndKeyword(location,keyword);
    }
}

