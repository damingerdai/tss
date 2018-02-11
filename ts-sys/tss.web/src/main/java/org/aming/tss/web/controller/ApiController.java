package org.aming.tss.web.controller;

import org.aming.service.DatabaseService;
import org.aming.tss.base.jdbc.DataBase;
import org.aming.tss.base.request.DataBaseRequest;
import org.quartz.Scheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author daming
 * @version 2018/1/27.
 */
@RestController
@Deprecated
public class ApiController {

    @Autowired
    private Scheduler scheduler;

    private DatabaseService databaseService;


    @RequestMapping(path = "/database/add", method = RequestMethod.PUT)
    public void addDatabase(DataBaseRequest request) {

    }




    public ApiController(DatabaseService databaseService) {
        super();
        this.databaseService = databaseService;
    }
}
