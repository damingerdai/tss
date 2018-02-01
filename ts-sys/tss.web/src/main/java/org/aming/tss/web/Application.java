package org.aming.tss.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author daming
 * @version 2018/1/27.
 */
@SpringBootApplication
@ComponentScan("org.aming")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
