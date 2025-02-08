package com.suyog.SpringBootRest;


import com.suyog.SpringBootRest.models.JobPost;
import com.suyog.SpringBootRest.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller /// using this annotation makes every method return a view
@CrossOrigin("http://localhost:3000/")
@RestController // if using this every method returns @ResponseBody (json data)
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    //@ResponseBody // this annotation makes a function return json response body in @Controller class
    public List<JobPost> getAllJobs() {
        return jobService.returnAllJobPosts();
    }

    // in this end point @PathVariablle will search for name mentioned and add that value to variable
    @GetMapping("jobPost/{jobPostId}")
    public JobPost getJobPost(@PathVariable("jobPostId") int id){
        return jobService.getJobPost(id);
    }

    // what ever data is being sent in request will be stored in request boy which will be mapped with variable
    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost job) {
        jobService.addJobPost(job);
        return job;
    }
}
