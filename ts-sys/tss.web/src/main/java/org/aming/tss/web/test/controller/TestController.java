package org.aming.tss.web.test.controller;

import org.aming.core.service.QrtzService;
import org.aming.core.service.ScheduleService;
import org.aming.tss.job.CsvJob;
import org.quartz.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daming
 * @version 2018/2/18.
 */
@RestController
@RequestMapping(path="/test")
public class TestController {
	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private QrtzService qrtzService;

	@GetMapping(path="/job/{jobCode}")
	public String getClass(@PathVariable("jobCode") String jobCode) {
		Class<CsvJob> csvJobClass = (Class<CsvJob>) qrtzService.getJobClass(jobCode);
		return csvJobClass.getName() + "    " + qrtzService.getJobClass(jobCode).getName();
	}
}
