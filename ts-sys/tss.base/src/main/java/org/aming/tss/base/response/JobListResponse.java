package org.aming.tss.base.response;

import com.google.common.collect.Lists;
import org.aming.tss.base.pojo.JobInfo;

import java.util.List;
import java.util.Objects;

/**
 * @author daming
 * @version 2018/3/3.
 */
public class JobListResponse extends Response {

	private static final long serialVersionUID = 314832974709538827L;
	private List<JobInfo> jobs;

	public List<JobInfo> getJobs() {
		return jobs;
	}

	public JobListResponse setJobs(List<JobInfo> jobs) {
		this.jobs = jobs;
		return this;
	}

	public void addJobInfo(JobInfo jobInfo) {
		if (Objects.isNull(jobs)) {
			jobs = Lists.newArrayList();
		}
		jobs.add(jobInfo);
	}

}
