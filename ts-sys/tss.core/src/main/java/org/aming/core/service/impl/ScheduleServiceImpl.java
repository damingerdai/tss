package org.aming.core.service.impl;

import org.aming.core.service.ScheduleService;
import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.pojo.JobInfo;
import org.aming.tss.base.request.CsvJobRequest;
import org.aming.tss.base.response.JobListResponse;
import org.aming.tss.base.response.Response;
import org.aming.tss.base.util.CommonUtils;
import org.aming.tss.job.CsvJob;
import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.JobKey.jobKey;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.TriggerKey.triggerKey;
import static org.quartz.impl.matchers.GroupMatcher.jobGroupEquals;

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

	@Override
	public JobListResponse getAllJobs() throws TssException {
		JobListResponse response = new JobListResponse();
		try {
			for (String groupName : scheduler.getJobGroupNames()) {
				for (JobKey jobKey : scheduler.getJobKeys(jobGroupEquals(groupName))) {
					String jobName = jobKey.getName();
					String jobGroup = jobKey.getGroup();

					List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
					if (!CommonUtils.isEmpty(triggers) && triggers.get(0) instanceof CronTrigger) {
						CronTrigger cronTrigger = (CronTrigger) triggers.get(0);
						String cronExpression = cronTrigger.getCronExpression();
						Trigger.TriggerState status = scheduler.getTriggerState(triggerKey(cronExpression, jobGroup));
						JobInfo info = new JobInfo()
								.setJobName(jobName)
								.setJobGroupName(jobGroup)
								.setCronExpression(cronExpression)
								.setStatus(status.ordinal());
						response.addJobInfo(info);
					}
				}
			}
		} catch (TssException ex) {

		} catch (Exception ex) {

		}
		return response;
	}


	public ScheduleServiceImpl(Scheduler scheduler) {
		super();
		this.scheduler = scheduler;
	}
}
