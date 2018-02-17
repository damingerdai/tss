package org.aming.tss.base.logger;

import com.google.common.collect.Maps;
import org.aming.tss.base.constant.CommonConstant;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author daming
 * @version 2018/1/28.
 */
public class LoggerManager {
    private static Map<String, TssLogger> cache = Maps.newHashMap();

    public static TssLogger getLogger(String loggerName) {
    	return cache.computeIfAbsent(loggerName, name -> {
    		return new TssLogger(LoggerFactory.getLogger(name));
		});

    }

    public static TssLogger getLogger(Class<?> className) {
        return getLogger(className.getName());
    }

    public static TssLogger getErrorLogger() {
    	return getLogger(CommonConstant.ERROR_LOGGER);
	}

	public static TssLogger getJdbcLogger() {
    	return getLogger(CommonConstant.JDBC_LOGGER);
	}
}
