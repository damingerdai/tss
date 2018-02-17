package org.aming.tss.web.controller;

import org.aming.core.service.DatabaseService;
import org.aming.tss.base.jdbc.Database;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author daming
 * @version 2018/2/4.
 */
@RestController
@RequestMapping(path = "database")
public class DatabaseController {

    private DatabaseService databaseService;

    @RequestMapping(path ="/all", method = RequestMethod.GET)
    public List<Database> getAllDatabase() {
        return databaseService.getAllDatabase();
    }

    public DatabaseController(DatabaseService databaseService) {
        super();
        this.databaseService = databaseService;
    }
}
