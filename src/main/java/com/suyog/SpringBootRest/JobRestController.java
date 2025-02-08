package com.suyog.SpringBootRest;


import com.suyog.SpringBootRest.models.JobPost;
import com.suyog.SpringBootRest.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@RestController
@Controller
public class JobRestController {

    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    @ResponseBody
    public List<JobPost> getAllJobs() {
        return jobService.returnAllJobPosts();
    }

}
