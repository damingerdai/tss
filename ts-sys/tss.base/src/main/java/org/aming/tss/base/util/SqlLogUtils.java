package org.aming.tss.base.util;

import org.aming.tss.base.logger.LoggerManager;
import org.aming.tss.base.logger.TssLogger;

import java.time.Duration;
import java.util.Objects;

/**
 * @author daming
 * @version 2018/2/15.
 */
public class SqlLogUtils {

	private static final TssLogger logger = LoggerManager.getJdbcLogger();

	public static void info(String sql, Object[] params, Duration duration) {
		logger.info("sql [{}] spends {} ms", replacePlaceholderWithParams(sql, params), duration.toMillis() / 1000.0);
	}

	private static String replacePlaceholderWithParams(String sql, Object[] params) {
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
