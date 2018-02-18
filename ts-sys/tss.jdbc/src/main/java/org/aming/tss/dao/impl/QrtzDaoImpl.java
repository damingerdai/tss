package org.aming.tss.dao.impl;

import org.aming.core.service.ExceptionService;
import org.aming.tss.base.constant.ErrorCodeConstant;
import org.aming.tss.base.exception.TssDaoException;
import org.aming.tss.base.logger.LoggerManager;
import org.aming.tss.base.logger.TssLogger;
import org.aming.tss.base.util.SqlLogUtils;
import org.aming.tss.dao.QrtzDao;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.time.Instant;

/**
 * @author daming
 * @version 2018/2/11.
 */
@Repository
public class QrtzDaoImpl implements QrtzDao {

	private final TssLogger logger = LoggerManager.getLogger(getClass());

    private JdbcTemplate jdbcTemplate;
    private ExceptionService exceptionService;

    @Override
    public String getJobClassName(String jobCode) throws TssDaoException {
        String sql = "select job_class from qrtz_job where job_code = ?";
        Object[] params = new Object[] { jobCode };
		Instant begin = Instant.now();
        try {
			return jdbcTemplate.query(sql, params, rs -> {
				if(rs.next()) {
					return rs.getString("job_class");
				}
				return null;

			});
        } catch (Exception ex) {
			throw exceptionService.buildTssDaoException(ErrorCodeConstant.ERR_DAO, sql, params, ex);
        } finally {
			SqlLogUtils.info(sql, params, Duration.between(begin, Instant.now()));
		}
    }

    public QrtzDaoImpl(JdbcTemplate jdbcTemplate) {
        super();
        this.jdbcTemplate = jdbcTemplate;
    }
}
