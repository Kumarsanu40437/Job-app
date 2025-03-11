package com.sanu.Jobapp;


import org.springframework.ui.Model;

import com.sanu.Jobapp.model.JobPost;
import com.sanu.Jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {
    @Autowired
    private JobService service;

    @GetMapping({"/","home"})
    public String home(){
        return "home";
    }
    @GetMapping("addjob")
    public String addJob(){
        return "addjob";
    }
    @PostMapping("handleForm")
     public String handleForm(JobPost jobPost){
        service.addJob(jobPost);
        return "success";
     }
    @GetMapping("viewalljobs")
    public String viewJobs(Model m) {
        List<JobPost> jobs = service.getAllJobs();
        m.addAttribute("jobPosts", jobs);

        return "viewalljobs";
    }
}
