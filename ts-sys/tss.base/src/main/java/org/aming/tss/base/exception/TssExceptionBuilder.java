package org.aming.tss.base.exception;

import org.aming.tss.base.logger.LoggerManager;
import org.aming.tss.base.logger.TssLogger;

/**
 * @author daming
 * @version 2018/1/27.
 */
public final class TssExceptionBuilder {

	private static final TssLogger logger = LoggerManager.getErrorLogger();

    public static TssException buildTssException(String code, String message, Throwable cause) {
    	logger.error("error code : {}, error message : {}, error cause : {}", code, message, cause);
        return new TssException(code, message, cause);
    }

    public static TssException buildTssException(String code, String message) {
		logger.error("error code : {}, error message : {}", code, message);
        return new TssException(code, message);
    }

    public static TssDaoException buildTssDaoException(String code, String message, String sql, Object[] params, Throwable cause) {
		logger.error("error code : {},  error message : {}, error cause: {}, sql : {}, params : {}", code, message, cause, sql, params);
		return new TssDaoException(code, message, sql, params, cause);
	}

	public static TssDaoException buildTssDaoException(String code, String message, String sql, Object[] params) {
		logger.error("error code : {},  error message : {}, sql : {}, params : {}", code, message, sql, params);
		return new TssDaoException(code, message, sql, params);
	}

    private static void log(TssException ex) {
    	logger.error("error code : {}, error message : {}, error cause : {}", ex.getCode(), ex.getMessage(), ex.cause);
	}
}
