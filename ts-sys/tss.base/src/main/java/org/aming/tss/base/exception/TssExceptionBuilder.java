package org.aming.tss.base.exception;

/**
 * @author daming
 * @version 2018/1/27.
 */
public class TssExceptionBuilder {

    public static TssException buildTssException(String code, String message, Throwable cause) {
        return new TssException(code, message, cause);
    }

    public static TssException buildTssException(String code, String message) {
        return new TssException(code, message);
    }
}
