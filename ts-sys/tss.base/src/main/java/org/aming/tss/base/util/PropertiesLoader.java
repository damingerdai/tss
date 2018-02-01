package org.aming.tss.base.util;

import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author daming
 * @version 2018/1/29.
 */
public class PropertiesLoader {

    Properties properties = new Properties();

    public Properties getProperties() {
        return properties;
    }

    public PropertiesLoader(Resource resource) {
       //init(resource);
    }

//    private void init(Resource resource) {
//        try(Input) {
//
//        } catch (Exception ex) {
//            throw new RuntimeException(ex.getMessage(), ex);
//        }
//
//        try (InputStream is = new FileInputStream(filePath)) {
//            properties.load(is);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public static PropertiesLoader getInstance(String filePath) {
//        return new PropertiesLoader(filePath);
//    }
}
