package org.aming.core.service.impl;

import org.aming.core.service.ExceptionService;
import org.aming.core.service.QrtzService;
import org.aming.tss.base.exception.TssDaoException;
import org.aming.tss.base.exception.TssException;
import org.aming.tss.dao.QrtzDao;
import org.quartz.Job;
import org.springframework.stereotype.Service;

/**
 * @author daming
 * @version 2018/2/11.
 */
@Service
public class QrtzServiceImpl implements QrtzService {

	private QrtzDao qrtzDao;
	private ExceptionService exceptionService;

    @Override
    public Class<? extends Job> getJobClass(String code) throws TssException {
		try {
			String className = qrtzDao.getJobClassName(code);
			return (Class<? extends Job>) Class.forName(className);
		} catch (TssDaoException | ClassNotFoundException ex) {
			throw exceptionService.buildServiceException("fail to load job '" + code + "'", ex);
		}
    }

    public  QrtzServiceImpl(QrtzDao qrtzDao,ExceptionService exceptionService) {
    	super();
    	this.qrtzDao = qrtzDao;
    	this.exceptionService = exceptionService;
	}
}
