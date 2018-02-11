package org.aming.core.service;

import org.aming.tss.base.exception.TssDaoException;
import org.aming.tss.base.exception.TssException;

/**
 * @author daming
 * @version 2018/2/4.
 */
public interface ExceptionService {

    TssException buildTssException(String code, Throwable cause);

    TssException buildTssException(String code);

    TssException buildTssException(String code, Object[] params, Throwable cause);

    TssException buildTssException(String code, Object[] params);

    TssDaoException buildTssDaoException(String code, String sql, Object[] params );
}
