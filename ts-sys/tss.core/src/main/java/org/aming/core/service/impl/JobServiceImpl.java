package org.aming.core.service.impl;

import org.aming.core.service.JobService;
import org.aming.tss.base.exception.TssDaoException;
import org.springframework.stereotype.Service;

/**
 * @author daming
 * @version 2018/2/11.
 */
@Service
public class JobServiceImpl implements JobService {

    @Override
    public Class<?> getJobClassName(String code) throws TssDaoException {
        return null;
    }
}
