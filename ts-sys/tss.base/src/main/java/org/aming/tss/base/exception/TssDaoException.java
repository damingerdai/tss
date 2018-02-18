package org.aming.tss.base.exception;


import org.aming.tss.base.constant.ErrorCodeConstant;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author daming
 * @version 2018/1/28.
 */
public class TssDaoException extends TssException {

    private String sql;
    private Object[] params;

    TssDaoException(String code, String message, String sql, Object[] params, Throwable cause) {
        super(code,message, cause);
        this.sql = sql;
        this.params = params;
    }

    TssDaoException(String code, String message, String sql, Object[] params) {
        super();
        this.code = code;
        this.message = message;
        this.sql = sql;
        this.params = params;
    }



    private String replacePlaceholderWithParams(String sql, Object[] params) {
        if (Objects.isNull(sql)) {
            return "";
        }
        if (Objects.nonNull(params)) {
            for (Object param: params) {
                sql = sql.replaceFirst("\\?", "'" + String.valueOf(param) + "'");
            }
        }
        return sql;
    }
}
