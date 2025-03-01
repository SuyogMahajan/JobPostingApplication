package com.suyog.SpringBootRest.services;

import com.suyog.SpringBootRest.models.DTO.JobDTO;
import com.suyog.SpringBootRest.models.DTO.JobFilterDTO;
import com.suyog.SpringBootRest.models.Job;
import com.suyog.SpringBootRest.repositories.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepo jobRepo;

    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    public Job createJob(JobDTO jobDTO) {
        Job job = jobDTO.getJob();
        return jobRepo.save(job);
    }

    public Job getJobById(int id) {
        Optional<Job> job = jobRepo.findById(id);
        return job.get();
    }

    public List<Job> getFilteredJobs(JobFilterDTO jobFilterDTO) {
        return jobRepo.getFilteredJobs(jobFilterDTO.getSearchKeyword(),
                jobFilterDTO.getLocationKeyword(),
                jobFilterDTO.getType(),
                jobFilterDTO.getMinSalary(),
                jobFilterDTO.getMaxSalary(),
                jobFilterDTO.getPostingDate()
        );
    }
}
