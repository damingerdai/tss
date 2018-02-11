package org.aming.tss.dao.impl;

import org.aming.tss.base.exception.TssDaoException;
import org.aming.tss.dao.QrtzDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author daming
 * @version 2018/2/11.
 */
@Repository
public class QrtzDaoImpl implements QrtzDao {

    private JdbcTemplate jdbcTemplate;

    @Override
    public String getJobClassName(String jobCode) throws TssDaoException {
        String sql = "select job_class from qrtz_job where job_code = ?";
        Object[] params = new Object[] { jobCode };
        try {

        } catch (Exception ex) {

        }
        return null;
    }

    public QrtzDaoImpl(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
}
