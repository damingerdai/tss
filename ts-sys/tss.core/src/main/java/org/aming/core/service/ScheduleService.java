package org.aming.core.service;

import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.request.JobRequest;

/**
 * @author daming
 * @version 2018/2/16.
 */
public interface ScheduleService {

	void addJob(JobRequest request) throws TssException;
}
