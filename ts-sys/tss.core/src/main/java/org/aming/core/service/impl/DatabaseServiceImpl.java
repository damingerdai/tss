package org.aming.core.service.impl;

import org.aming.core.service.DatabaseService;
import org.aming.core.service.ExceptionService;
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
        return databaseDao.getAllDataBase();
    }

	@Override
	public DataSource getDataBase(String databaseName) throws TssException {
    	try {
			Database dataBase = databaseDao.getDataBase(databaseName);
//			DataBaseType dbt = DataBaseType.getDataBaseType(dataBase.getType());
//			if (dbt == DataBaseType.MYSQL) {
//				HikariDataSource dataSource = new HikariDataSource();
//			}
			throw new RuntimeException("该数据库尚不支持");
		} catch (Exception ex) {

		}
		return null;
	}

	private JdbcInfo getMysqlJdbcInfo(Database dataBase) {
    	String driver = "com.mysql.cj.jdbc.Driver";
    	String url = "null";
    	return null;
	}

	public DatabaseServiceImpl(DatabaseDao databaseDao,ExceptionService exceptionService) {
        super();
        this.databaseDao = databaseDao;
        this.exceptionService = exceptionService;
    }
}
