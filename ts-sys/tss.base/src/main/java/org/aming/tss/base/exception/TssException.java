package org.aming.tss.base.exception;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author daming
 * @version 2018/1/27.
 */
public class TssException extends RuntimeException {

    private static final long serialVersionUID = -3474720967116751671L;

    protected String code;
    protected String message;
    protected Throwable cause;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    TssException(String code, String message, Throwable cause) {
        super();
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

    TssException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    TssException(String message, Throwable cause) {
        super();
        this.message = message;
        this.cause = cause;
    }

    public TssException() {
        super();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
