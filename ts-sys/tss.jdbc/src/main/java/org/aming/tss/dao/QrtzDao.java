package org.aming.tss.dao;

import org.aming.tss.base.exception.TssDaoException;

/**
 * @author daming
 * @version 2018/2/11.
 */
public interface QrtzDao {

    String getJobClassName(String jobCode) throws TssDaoException;
}
