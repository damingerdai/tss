package org.aming.tss.base.exception;

import org.aming.tss.base.constant.ErrorCodeConstant;

/**
 * @author daming
 * @version 2018/1/28.
 */
public class TssServiceException extends TssException {

    TssServiceException(String code, String message, Throwable cause) {
        super();
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

    TssServiceException(String message, Throwable cause) {
        super();
        this.code = ErrorCodeConstant.ERR_SERVICE;
        this.message = message;
        this.cause = cause;
    }

    TssServiceException(String message) {
        super();
        this.code = ErrorCodeConstant.ERR_SERVICE;
        this.message = message;
    }
}
