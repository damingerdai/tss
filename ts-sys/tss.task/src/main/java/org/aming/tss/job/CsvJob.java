package org.aming.tss.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author daming
 * @version 2018/1/30.
 */
public class CsvJob implements Job {

	private String csvOutPath;
	private String dataBaseName;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

    }
}
