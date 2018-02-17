package org.aming.tss.web.controller;

import org.aming.core.service.QrtzService;
import org.aming.tss.base.request.JobRequest;
import org.aming.tss.base.response.Response;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.quartz.JobBuilder.newJob;

/**
 * @author daming
 * @version 2018/2/10.
 */
@RestController
@RequestMapping(path = "/job")
public class SchedulerController {

    private Scheduler scheduler;

    private QrtzService qrtzService;

    @PostMapping(path = "/addJob")
    public Response addJob(JobRequest request) {
        try {
        	Class<? extends Job> jobClass = qrtzService.getJobClass(request.getJobCode());
			JobDetail jobDetail = newJob(jobClass)
					.withIdentity(JobKey.jobKey(request.getJobName(), request.getJobGroup()))
					.build();

        } catch (Exception ex) {

        }
        return null;
    }

    public SchedulerController(Scheduler scheduler,QrtzService qrtzService) {
        super();
        this.scheduler = scheduler;
        this.qrtzService =  qrtzService;
    }
}