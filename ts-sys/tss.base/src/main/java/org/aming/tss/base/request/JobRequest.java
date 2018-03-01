package org.aming.tss.base.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * @author daming
 * @version 2018/2/18.
 */
public class JobRequest implements Serializable {
	private static final long serialVersionUID = 414337769458305760L;

	private String jobName;
	private String jobGroup;
	private String cronExpression;

	public String getJobName() {
		return jobName;
	}

	public JobRequest setJobName(String jobName) {
		this.jobName = jobName;
		return this;
	}

	public String getJobGroup() {
		return jobGroup;
	}

	public JobRequest setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
		return this;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public JobRequest setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
		return this;
	}

	public JobRequest() {
		super();
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
