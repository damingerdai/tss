package org.aming.core.service;

import org.aming.tss.base.exception.TssException;
import org.quartz.Job;

/**
 * quartz的job信息服务类
 * @author daming
 * @version 2018/2/11.
 */
@Deprecated
public interface QrtzService {

    Class<? extends Job> getJobClass(String code) throws TssException;
}
