package org.aming.tss.dao;

import org.aming.tss.base.exception.TssDaoException;
import org.aming.tss.base.jdbc.Database;

import java.util.List;

/**
 * @author daming
 * @version 2018/2/4.
 */
public interface DatabaseDao {

    List<Database> getAllDataBase() throws TssDaoException;

	Database getDataBase(String databaseName);
}
