package org.aming.config;

import org.aming.tss.base.props.ErrorProp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author daming
 * @version 2018/2/4.
 */
@Configuration
public class ErrorConfig {

    @Bean
    public ErrorProp errorProp() throws IOException {
        Resource resource = new ClassPathResource("errorcode.properties");
        Properties properties = PropertiesLoaderUtils.loadProperties(resource);
        return new ErrorProp(properties);
    }
}
