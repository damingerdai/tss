package org.aming.tss.web.controller;


import org.aming.core.service.ExceptionService;
import org.aming.core.service.ScheduleService;
import org.aming.core.service.ValidateService;
import org.aming.tss.base.request.CsvJobRequest;
import org.aming.tss.base.response.Response;

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

    private ScheduleService scheduleService;

    private ExceptionService exceptionService;

    private ValidateService validateService;

    @PostMapping(path = "/addJob")
    public Response addJob(CsvJobRequest request) {
        try {
 			validateService.validateCsvJobRequest(request);
 			return scheduleService.addJob(request);
        } catch (Exception ex) {

        }
        return null;
    }

    public SchedulerController(ScheduleService scheduleService,ExceptionService exceptionService,ValidateService validateService){
        super();
        this.scheduleService = scheduleService;
        this.exceptionService =  exceptionService;
        this.validateService = validateService;
    }
}