package org.aming.core.service;

import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.request.CsvJobRequest;
import org.aming.tss.base.response.JobListResponse;
import org.aming.tss.base.response.Response;

/**
 * @author daming
 * @version 2018/2/16.
 */
public interface ScheduleService {

	/**
	 * 添加一个job
	 * @param request
	 * @throws TssException
	 */
	Response addJob(CsvJobRequest request) throws TssException;

	boolean existJob(String jobName, String jobGroup);

	JobListResponse getAllJobs() throws TssException;
}
