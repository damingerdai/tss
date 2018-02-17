package org.aming.core.service;

import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.jdbc.Database;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author daming
 * @version 2018/2/4.
 */
public interface DatabaseService {


    List<Database> getAllDatabase();

    DataSource getDataBase(String databaseName) throws TssException;
}
