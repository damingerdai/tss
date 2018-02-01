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

    TssDaoException(String sql, Object[] params, Throwable cause) {
        super();
        this.code = ErrorCodeConstant.ERR_DAO;
        this.sql = sql;
        this.params = Arrays.copyOf(params, params.length);
        this.message = "fail to execute sql: " + replacePlaceholderWithParams(sql, params);
    }

    TssDaoException(String sql, Throwable cause) {
        super();
        this.code = ErrorCodeConstant.ERR_DAO;
        this.sql = sql;
        this.message = "fail to execute sql: " + sql;
    }

    private String replacePlaceholderWithParams(String sql, Object[] params) {
        if (Objects.isNull(sql)) {
            return "";
        }
        if (Objects.nonNull(params)) {
            for (Object param: params) {
                sql = sql.replaceFirst("\\?", String.valueOf(param));
            }
        }
        return sql;
    }
}
