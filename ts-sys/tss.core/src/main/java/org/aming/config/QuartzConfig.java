package org.aming.config;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author daming
 * @version 2018/1/29.
 */
@Configuration
public class QuartzConfig {

    @Bean
    @Qualifier("quartzProperites")
    public Properties quartzProperties() throws IOException {
        return PropertiesLoaderUtils.loadAllProperties("quartz.properties");
    }

    @Bean
    public SchedulerFactory schedulerFactory(@Qualifier("quartzProperites") Properties properties) throws SchedulerException {
        return new StdSchedulerFactory(properties);
    }

    @Bean
    public Scheduler scheduler(SchedulerFactory schedulerFactory) throws SchedulerException {
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        return scheduler;
    }
}
