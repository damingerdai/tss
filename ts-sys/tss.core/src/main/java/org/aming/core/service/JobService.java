package org.aming.core.service;

import org.aming.tss.base.exception.TssDaoException;

/**
 * quartz的job信息服务类
 * @author daming
 * @version 2018/2/11.
 */
public interface JobService {

    Class<?> getJobClassName(String code) throws TssDaoException;
}
