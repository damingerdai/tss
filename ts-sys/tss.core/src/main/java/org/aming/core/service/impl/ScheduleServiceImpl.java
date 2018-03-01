package org.aming.core.service.impl;

import org.aming.core.service.QrtzService;
import org.aming.core.service.ScheduleService;
import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.request.CsvJobRequest;
import org.aming.tss.base.response.Response;
import org.aming.tss.job.CsvJob;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.stereotype.Service;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.JobKey.jobKey;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.TriggerKey.triggerKey;

/**
 * @author daming
 * @version 2018/2/18.
 */
@Service
public class ScheduleServiceImpl implements ScheduleService {


	private Scheduler scheduler;

	@Override
	public Response addJob(CsvJobRequest request) throws TssException {
		try {
			JobDataMap map = buildJobDataMap(request);

			JobDetail jobDetail = buildJobDetail(request, map);

			Trigger trigger = buildTrigger(request);

			scheduler.scheduleJob(jobDetail, trigger);

			return new Response();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;

	}

	private JobDataMap buildJobDataMap(CsvJobRequest request) {
		JobDataMap map = new JobDataMap();
		map.put("dataBaseName", request.getDataBaseName());
		map.put("csvOutPath", request.getCsvOutPath());
		map.put("sender", request.getSender());
		return map;
	}


	private JobDetail buildJobDetail(CsvJobRequest request, JobDataMap map) {
		return newJob()
				.ofType(CsvJob.class)
				.withIdentity(jobKey(request.getJobName(), request.getJobGroup()))
				.usingJobData(map)
				.build();
	}

	private Trigger buildTrigger(CsvJobRequest request) {
		return newTrigger()
				.withIdentity(triggerKey(request.getCronExpression(),request.getJobGroup()))
				.withSchedule(cronSchedule(request.getCronExpression()))
				.build();
	}


	@Override
	public boolean existJob(String jobName, String jobGroup) {
		return false;
	}


	public ScheduleServiceImpl(Scheduler scheduler) {
		super();
		this.scheduler = scheduler;
	}
}
