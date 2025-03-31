package com.suyog.SpringBootRest.controllers;


import com.suyog.SpringBootRest.constants.AppConstants;
import com.suyog.SpringBootRest.models.DTO.JobDTO;
import com.suyog.SpringBootRest.models.DTO.JobFilterDTO;
import com.suyog.SpringBootRest.models.Job;
import com.suyog.SpringBootRest.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping(AppConstants.API_BASE_PATH)
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("jobs")
    public List<Job> getAllJobs() {
        List<Job> jobs = jobService.getAllJobs();
        return jobs;
    }

    @GetMapping("job/{id}")
    public Job getJobById(@PathVariable int id) {
        return jobService.getJobById(id);
    }

    @PostMapping("job")
    public Job createJob(@RequestBody JobDTO jobDTO) {
        return jobService.createJob(jobDTO);
    }

    @PostMapping("job/filter")
    public List<Job> getJobByKeyword(@RequestBody JobFilterDTO jobFilterDTO) {
        List<Job> jobs = jobService.getFilteredJobs(jobFilterDTO);
        return jobs;
    }

}
