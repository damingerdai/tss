package org.aming.tss.dao.impl;

import org.aming.tss.base.constant.ErrorCodeConstant;
import org.aming.tss.base.ds.Page;
import org.aming.tss.base.ds.mysql.Column;
import org.aming.tss.base.exception.TssDaoException;
import org.aming.tss.base.exception.TssException;
import org.aming.tss.base.exception.TssExceptionBuilder;
import org.aming.tss.base.util.MysqlParser;
import org.aming.tss.dao.DsDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author daming
 * @version 2018/2/25.
 */
@Repository
@Qualifier("MySqlDsDao")
public class MySqlDsDao implements DsDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public String getDataSourceName() throws TssException {
		String sql = "select database()";
		 try {
			 return jdbcTemplate.queryForObject(sql, String.class);
		 } catch (Exception ex) {
		 	throw TssExceptionBuilder.buildTssDaoException(ErrorCodeConstant.ERR_DAO, "fail to get database name", sql, null,ex);
		 }


	}

	@Override
	public List<String> getTableNames() throws TssException {
		String sql = "show tables";
		try {
			return jdbcTemplate.query(sql, (rs,i) -> {
				return rs.getString(1);
			});
		} catch (Exception ex) {
			throw TssExceptionBuilder.buildTssDaoException(ErrorCodeConstant.ERR_DAO, "fail to get all tables name", sql, null,ex);
		}
	}

	@Override
	public List<Column> getColumns(String tableName) throws TssException {
		String sql = "desc ? ";
		Object[] params = new Object[] { tableName };
		try {
			return jdbcTemplate.query(sql, params, (rs,i) -> {
				return new Column()
						.setField(rs.getString(1))
						.setType(rs.getString(2))
						.setNullFlag(rs.getString(3))
						.setDefaultValue(rs.getString(4))
						.setExtra(rs.getString(5));
			});
		} catch (Exception ex) {
			throw TssExceptionBuilder.buildTssDaoException(ErrorCodeConstant.ERR_DAO, "fail to get all tables", sql, params,ex);
		}
	}

	@Override
	public ResultSet getResultSet(Column table) throws TssException {
		return null;
	}

	@Override
	public List<String[]> getData(String tables, String[] columnNames, Page page) throws TssDaoException {
		String sql = MysqlParser.selectLimit(tables, columnNames, page);
		try {
			return jdbcTemplate.query(sql, (rs,i) -> {
				 return mapRows(rs, columnNames);
			});
		} catch (Exception ex) {
			throw TssExceptionBuilder.buildTssDaoException(ErrorCodeConstant.ERR_DAO, "fail to get data", sql,null,ex);
		}
	}

	private String[] mapRows(ResultSet rs, String[] columnNames) throws SQLException {
		String[] result = new String[columnNames.length];
		for (int i=0; i < columnNames.length; i++) {
			result[i] = rs.getString(i+1);
		}
		return result;
	}

	public MySqlDsDao(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
}
