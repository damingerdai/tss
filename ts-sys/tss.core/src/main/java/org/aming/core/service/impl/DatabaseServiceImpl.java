package org.aming.core.service.impl;

import org.aming.core.service.DatabaseService;
import org.aming.tss.base.jdbc.DataBase;
import org.aming.tss.dao.DatabaseDao;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author daming
 * @version 2018/2/4.
 */
@Service
public class DatabaseServiceImpl implements DatabaseService {

    private DatabaseDao databaseDao;

    @Override
    public List<DataBase> getAllDatabase() {
        return databaseDao.getAllDataBase();
    }

    public DatabaseServiceImpl(DatabaseDao databaseDao) {
        super();
        this.databaseDao = databaseDao;
    }
}
