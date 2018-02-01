package org.aming.tss.base.exception;

import org.aming.tss.base.constant.ErrorCodeConstant;

/**
 * @author daming
 * @version 2018/1/27.
 */
public class TssWebException extends TssException {

    TssWebException(String code, String message, Throwable cause) {
        super();
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

    TssWebException(String message, Throwable cause) {
        super();
        this.code = ErrorCodeConstant.ERR_WEB;
        this.message = message;
        this.cause = cause;
    }

    TssWebException(String message) {
        super();
        this.code = ErrorCodeConstant.ERR_WEB;
        this.message = message;
    }
}
