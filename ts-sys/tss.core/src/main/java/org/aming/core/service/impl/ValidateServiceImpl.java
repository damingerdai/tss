package org.aming.core.service.impl;

import org.aming.core.service.ExceptionService;
import org.aming.core.service.ValidateService;
import org.aming.tss.base.constant.ErrorCodeConstant;
import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.request.CsvJobRequest;
import org.aming.tss.base.request.JobRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author daming
 * @version 2018/2/18.
 */
@Service
public class ValidateServiceImpl implements ValidateService {

	private ExceptionService exceptionService;

	@Override
	public void validateJobRequest(JobRequest jobRequest) throws TssException {
		if (Objects.isNull(jobRequest)) {
			 throw exceptionService.buildTssException(ErrorCodeConstant.ERR_REQUEST, "request is required");
		}
		String jobName = jobRequest.getJobName();
		String jobGroup = jobRequest.getJobGroup();

		validateJobNameAndGroup(jobName, jobGroup);
		String cronExpression = jobRequest.getCronExpression();
		if (StringUtils.isBlank(cronExpression)) {
			throw exceptionService.buildTssException(ErrorCodeConstant.ERR_REQUEST, "cron expression is invalid");
		}

	}

	@Override
	public void validateCsvJobRequest(CsvJobRequest request) throws TssException {
		validateJobRequest(request);

		if (StringUtils.isBlank(request.getDataBaseName())) {
			throw exceptionService.buildTssException(ErrorCodeConstant.ERR_REQUEST, "database name is required");
		}

		if (StringUtils.isBlank(request.getCsvOutPath())) {
			throw exceptionService.buildTssException(ErrorCodeConstant.ERR_REQUEST, "csv out path is required");
		}
	}

	private void validateJobNameAndGroup(String jobName, String jobGroup) throws TssException {
		if (StringUtils.isBlank(jobName)) {
			throw exceptionService.buildTssException(ErrorCodeConstant.ERR_REQUEST, "jobName should not be blank");
		}
		if (StringUtils.isBlank(jobGroup)) {
			throw exceptionService.buildTssException(ErrorCodeConstant.ERR_REQUEST, "jodGroup should not be blank");
		}


	}

	public ValidateServiceImpl(ExceptionService exceptionService) {
		super();
		this.exceptionService = exceptionService;
	}
}
