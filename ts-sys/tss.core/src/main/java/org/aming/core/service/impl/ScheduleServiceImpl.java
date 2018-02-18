package org.aming.core.service.impl;

import org.aming.core.service.QrtzService;
import org.aming.core.service.ScheduleService;
import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.request.JobRequest;
import org.aming.tss.job.CsvJob;
import org.apache.commons.lang3.ClassUtils;
import org.quartz.Job;
import org.quartz.Scheduler;
import org.springframework.stereotype.Service;

/**
 * @author daming
 * @version 2018/2/18.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {

	private QrtzService qrtzService;
	private Scheduler scheduler;

	@Override
	public void addJob(JobRequest request) throws TssException {
		// 获取job类型
		Class<? extends Job> clazz = null;// qrtzService.getJobClass(request.getJobCode());


	}

	public ScheduleServiceImpl(QrtzService qrtzService,Scheduler scheduler) {
		super();
		this.qrtzService = qrtzService;
		this.scheduler = scheduler;
	}
}
