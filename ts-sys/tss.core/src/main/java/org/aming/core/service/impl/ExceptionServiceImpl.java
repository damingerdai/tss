package org.aming.core.service.impl;

import org.aming.core.service.ExceptionService;
import org.aming.tss.base.exception.TssDaoException;
import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.exception.TssExceptionBuilder;
import org.aming.tss.base.logger.LoggerManager;
import org.aming.tss.base.logger.TssLogger;
import org.aming.tss.base.props.ErrorProp;

/**
 * @author daming
 * @version 2018/2/4.
 */
public class ExceptionServiceImpl implements ExceptionService {

    private final TssLogger logger = LoggerManager.getLogger("error.logger");

    private ErrorProp errorProp;

    @Override
    public TssException buildTssException(String code, Throwable cause) {
        String message = errorProp.getErrorMessage(code);
        logger.error(message);
        return TssExceptionBuilder.buildTssException(code, message, cause);
    }

    @Override
    public TssException buildTssException(String code) {
        String message = errorProp.getErrorMessage(code);
        logger.error(message);
        return TssExceptionBuilder.buildTssException(code, message);
    }

    @Override
    public TssException buildTssException(String code, Object[] params, Throwable cause) {
        String message = String.format(errorProp.getErrorMessage(code), params);
        logger.error(message);
        return TssExceptionBuilder.buildTssException(code, message, cause);
    }

    @Override
    public TssException buildTssException(String code, Object[] params) {
        String message = String.format(errorProp.getErrorMessage(code), params);
        logger.error(message);
        return TssExceptionBuilder.buildTssException(code, message);
    }

    @Override
    public TssDaoException buildTssDaoException(String code, String sql, Object[] params) {
        throw new RuntimeException("尚未实现");
    }

    public ExceptionServiceImpl(ErrorProp errorProp) {
        super();
        this.errorProp = errorProp;
    }
}
