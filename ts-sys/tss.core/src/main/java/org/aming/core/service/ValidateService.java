package org.aming.core.service;

import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.request.CsvJobRequest;
import org.aming.tss.base.request.JobRequest;

/**
 * @author daming
 * @version 2018/2/18.
 */

public interface ValidateService {

	/**
	 * 校验一个job请求
	 * @param jobRequest
	 * @throws TssException
	 */
	void validateJobRequest(JobRequest jobRequest) throws TssException;

	void validateCsvJobRequest(CsvJobRequest request) throws TssException;
}
