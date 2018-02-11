package org.aming.tss.dao.impl;

import org.aming.tss.base.exception.TssExceptionBuilder;
import org.aming.tss.base.jdbc.DataBase;
import org.aming.tss.base.logger.LoggerManager;
import org.aming.tss.base.logger.TssLogger;
import org.aming.tss.dao.DatabaseDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

/**
 * @author daming
 * @version 2018/2/4.
 */
@Repository
public class DatabaseDaoImpl implements DatabaseDao {

    private final TssLogger logger = LoggerManager.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<DataBase> getAllDataBase() {
        Instant begin = Instant.now();
        String sql = "select databaseName,host,port,username,`password`, `type` from `database`";
        try {
            return jdbcTemplate.query(sql, (rs,i) -> {
                return new DataBase().
                        setDatabaseName(rs.getString("databaseName"))
                        .setHost(rs.getString("host"))
                        .setPort(rs.getInt("port"))
                        .setUsername(rs.getString("username"))
                        .setPassword(rs.getString("password"))
                        .setPort(rs.getInt("type"));
            });
        } catch (Exception ex) {
            logger.error("fail to get all database", ex);
        } finally {

        }
        return null;
    }


    public DatabaseDaoImpl(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
}
