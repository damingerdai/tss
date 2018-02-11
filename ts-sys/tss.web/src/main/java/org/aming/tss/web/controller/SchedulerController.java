package org.aming.tss.web.controller;

import org.aming.tss.base.request.JobRequest;
import org.aming.tss.base.response.Response;
import org.quartz.Scheduler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daming
 * @version 2018/2/10.
 */
@RestController
@RequestMapping(path = "/job")
public class SchedulerController {

    private Scheduler scheduler;

    @PostMapping(path = "/addJob")
    public Response addJob(JobRequest request) {
        try {


        } catch (Exception ex) {

        }
        return null;
    }

    public SchedulerController(Scheduler scheduler) {
        super();
        this.scheduler = scheduler;
    }
}