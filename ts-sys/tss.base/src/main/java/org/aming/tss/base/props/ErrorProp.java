package org.aming.tss.base.props;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * @author daming
 * @version 2018/2/4.
 */
public class ErrorProp implements Serializable {

    private static final long serialVersionUID = -2008464500067896594L;

    private Map<String, String> enCache;

    public String getErrorMessage(String errorCode) {
        return enCache.get(errorCode);
    }

    public ErrorProp(Map<String, String> enCache) {
        super();
        this.enCache = ImmutableMap.copyOf(enCache);
    }

    public ErrorProp(Properties properties) {
        super();
        this.enCache = toMap(properties);
    }

    /**
     * 由于properties本质上是一个Map <Object,Object>上的map，所以需要转换
     *
     * @param properties
     * @return
     */
    private Map<String, String> toMap(Properties properties) {
        Map<String, String> map = Maps.newHashMap();
        properties.forEach( (k,v) -> {
            if (Objects.nonNull(k) && Objects.nonNull(v)) {
                map.put(String.valueOf(k), String.valueOf(v));
            }
        });

        return ImmutableMap.copyOf(map);
    }
}
