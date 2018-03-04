package org.aming.tss.base.pojo;

import java.io.Serializable;

/**
 * @author daming
 * @version 2018/3/3.
 */
public class JobInfo implements Serializable {
	private static final long serialVersionUID = 4105301025007475995L;

	private String jobName;
	private String jobGroupName;
	private String cronExpression;
	private int Status;

	public String getJobName() {
		return jobName;
	}

	public JobInfo setJobName(String jobName) {
		this.jobName = jobName;
		return this;
	}

	public String getJobGroupName() {
		return jobGroupName;
	}

	public JobInfo setJobGroupName(String jobGroupName) {
		this.jobGroupName = jobGroupName;
		return this;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public JobInfo setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
		return this;
	}

	public int getStatus() {
		return Status;
	}

	public JobInfo setStatus(int status) {
		Status = status;
		return this;
	}
}
