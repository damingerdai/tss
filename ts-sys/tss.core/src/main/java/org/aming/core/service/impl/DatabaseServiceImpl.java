package org.aming.core.service.impl;

import org.aming.core.service.DatabaseService;
import org.aming.core.service.ExceptionService;
import org.aming.tss.base.constant.ErrorCodeConstant;
import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.jdbc.Database;
import org.aming.tss.dao.DatabaseDao;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

/**
 * @author daming
 * @version 2018/2/4.
 */
@Service
public class DatabaseServiceImpl implements DatabaseService {

    private DatabaseDao databaseDao;
    private ExceptionService exceptionService;

    @Override
    public List<Database> getAllDatabase() throws TssException{
		try {
			return databaseDao.getAllDataBase();
		} catch (TssException ex) {
			throw ex;
		} catch (Exception ex) {
			throw exceptionService.buildTssException(ErrorCodeConstant.COMMON_ERR, "fail to get all data base info");
		}
    }

	@Override
	public Database getDataBase(String databaseName) throws TssException {
    	try {
			return databaseDao.getDataBase(databaseName);
		} catch (TssException ex) {
    		throw ex;
		} catch (Exception ex) {
			throw exceptionService.buildTssException(ErrorCodeConstant.COMMON_ERR, "fail to get data base info");
		}
	}


	public DatabaseServiceImpl(DatabaseDao databaseDao,ExceptionService exceptionService) {
        super();
        this.databaseDao = databaseDao;
        this.exceptionService = exceptionService;
    }
}
