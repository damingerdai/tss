package org.aming.tss.web.controller;

import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daming
 * @version 2018/1/27.
 */
@RestController
public class ApiController {

    @Autowired
    private Scheduler scheduler;

    @RequestMapping(path = "/")
    public String test() {
        Logger logger = LoggerFactory.getLogger(ApiController.class);
        logger.error("我在测试");
        return "test";
    }
}
