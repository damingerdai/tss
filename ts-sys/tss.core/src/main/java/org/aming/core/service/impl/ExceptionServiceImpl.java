package org.aming.core.service.impl;

import org.aming.core.service.ErrorCodeService;
import org.aming.core.service.ExceptionService;
import org.aming.tss.base.constant.ErrorCodeConstant;
import org.aming.tss.base.exception.TssDaoException;
import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.exception.TssExceptionBuilder;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * @author daming
 * @version 2018/2/4.
 */
@Service
public class ExceptionServiceImpl implements ExceptionService {

    private ErrorCodeService errorCodeService;

    @Override
    public TssException buildTssException(String code, Throwable cause) {
        String message = errorCodeService.getErrorMessage(code);
        return TssExceptionBuilder.buildTssException(code, message, cause);
    }

    @Override
    public TssException buildTssException(String code) {
        String message = errorCodeService.getErrorMessage(code);
        return TssExceptionBuilder.buildTssException(code, message);
    }

    @Override
    public TssException buildTssException(String code, Object[] params, Throwable cause) {
        String message = String.format(errorCodeService.getErrorMessage(code), params);
        return TssExceptionBuilder.buildTssException(code, message, cause);
    }

    @Override
    public TssException buildTssException(String code, Object[] params) {
        String message = String.format(errorCodeService.getErrorMessage(code), params);
        return TssExceptionBuilder.buildTssException(code, message);
    }

    @Override
    public TssDaoException buildTssDaoException(String code, String sql, Object[] params, Throwable cause) {
		String message = MessageFormat.format(errorCodeService.getErrorMessage(code), sql);
        return TssExceptionBuilder.buildTssDaoException(code, message, sql, params, cause);
    }

	@Override
	public TssDaoException buildTssDaoException(String code, String sql, Object[] params) {
		String message = MessageFormat.format(errorCodeService.getErrorMessage(code), sql);
		return TssExceptionBuilder.buildTssDaoException(code, message, sql, params);
	}

	@Override
	public TssDaoException buildTssDaoSystemException(String message, String sql, Object[] params, Throwable cause) {
    	message = MessageFormat.format(errorCodeService.getErrorMessage(ErrorCodeConstant.COMMON_ERR), message);
		return  TssExceptionBuilder.buildTssDaoException(ErrorCodeConstant.COMMON_ERR, message, sql, params, cause);
	}

	@Override
	public TssException buildServiceException(String message, Throwable cause) {
    	message = MessageFormat.format(errorCodeService.getErrorMessage(ErrorCodeConstant.COMMON_ERR), message);
		return TssExceptionBuilder.buildTssException(ErrorCodeConstant.COMMON_ERR, message, cause);
	}


	public ExceptionServiceImpl(ErrorCodeService errorCodeService) {
        super();
        this.errorCodeService = errorCodeService;
    }
}
