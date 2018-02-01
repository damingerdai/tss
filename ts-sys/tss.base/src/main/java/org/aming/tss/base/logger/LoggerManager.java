package org.aming.tss.base.logger;

import com.google.common.collect.Maps;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * @author daming
 * @version 2018/1/28.
 */
public class LoggerManager {
    private static Map<String, TssLogger> cache = Maps.newHashMap();

    public static TssLogger getLogger(String loggerName) {
        if (cache.containsKey(loggerName)) {
            return cache.get(loggerName);
        } else {
            TssLogger tssLogger = new TssLogger(LoggerFactory.getLogger(loggerName));
            cache.put(loggerName, tssLogger);
            return tssLogger;
        }
    }

    public static TssLogger getLogger(Class<?> className) {
        return getLogger(className.getName());
    }
}
