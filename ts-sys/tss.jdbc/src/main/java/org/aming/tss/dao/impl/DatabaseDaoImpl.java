package org.aming.tss.dao.impl;

import org.aming.core.service.ExceptionService;
import org.aming.tss.base.constant.ErrorCodeConstant;
import org.aming.tss.base.enums.DataBaseType;
import org.aming.tss.base.exception.TssDaoException;
import org.aming.tss.base.jdbc.Database;
import org.aming.tss.base.logger.LoggerManager;
import org.aming.tss.base.logger.TssLogger;
import org.aming.tss.base.util.SqlLogUtils;
import org.aming.tss.dao.DatabaseDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

/**
 * @author daming
 * @version 2018/2/4.
 */
@Repository
public class DatabaseDaoImpl implements DatabaseDao {

    private final TssLogger logger = LoggerManager.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;
    private ExceptionService exceptionService;

    @Override
    public List<Database> getAllDataBase() throws TssDaoException {
        Instant begin = Instant.now();
        String sql = "select id,`name`, driver, url,`username`,`password` from `database` where `status` = 1";
        try {
            return jdbcTemplate.query(sql, (rs,i) -> {
                return getDataBaseFromResultSet(rs);
            });
        } catch (Exception ex) {
            throw exceptionService.buildTssDaoException(ErrorCodeConstant.ERR_DAO,sql,null,ex);
        } finally {
			SqlLogUtils.info(sql, null, Duration.between(begin, Instant.now()));
        }
    }


	@Override
	public Database getDataBase(String databaseName) throws TssDaoException {
    	String sql = "select id,`name`, driver, url,`username`,`password`,`type` from `database` where `status` = 1 where name = ?";
    	Object[] params = new Object[] { databaseName };
    	Instant begin = Instant.now();
    	try {
			Optional<Database> optional = Optional.of(jdbcTemplate.query(sql, params, rs -> {
				while (rs.next()) {
					return getDataBaseFromResultSet(rs);
				}
				return null;
			}));
			return optional.get();
		} catch (NullPointerException ex) {
			throw exceptionService.buildTssDaoException(ex.getMessage(), sql, params, ex);
		} catch (Exception ex) {
			throw exceptionService.buildTssDaoException(ErrorCodeConstant.ERR_DAO, sql, params, ex);
		} finally {
			SqlLogUtils.info(sql, null, Duration.between(begin, Instant.now()));
		}
	}

	private Database getDataBaseFromResultSet(ResultSet rs) throws SQLException {
		return new Database()
				.setId(rs.getInt("id"))
				.setName(rs.getString("name"))
				.setDriver(rs.getString("driver"))
				.setUsername(rs.getString("username"))
				.setPassword(rs.getString("password"))
				.setType(DataBaseType.getDataBaseType(rs.getInt("type")));
	}

	public DatabaseDaoImpl(JdbcTemplate jdbcTemplate,ExceptionService exceptionService) {
        super();
        this.jdbcTemplate = jdbcTemplate;
        this.exceptionService = exceptionService;
    }
}
