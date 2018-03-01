package org.aming.tss.job;

import com.opencsv.CSVWriter;
import com.zaxxer.hikari.HikariDataSource;
import org.aming.core.service.DatabaseService;
import org.aming.tss.base.ds.Page;
import org.aming.tss.base.ds.mysql.Column;
import org.aming.tss.base.enums.DataBaseType;
import org.aming.tss.base.jdbc.Database;
import org.aming.tss.base.util.CommonUtils;
import org.aming.tss.base.util.DateUtils;
import org.aming.tss.base.util.SpringContextHolder;
import org.aming.tss.dao.DsDao;
import org.aming.tss.dao.impl.MySqlDsDao;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import java.util.Objects;

/**
 * @author daming
 * @version 2018/1/30.
 */
public class CsvJob implements Job {

	private String csvOutPath;
	private String dataBaseName;
	private String sender;

	private DsDao dsDao;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
    	try {

    		// 根据数据名字获取数据源
			Database ds = SpringContextHolder.getBean(DatabaseService.class).getDataBase(dataBaseName);

			if (ds.getType() == DataBaseType.MYSQL) {
				DataSource dataSource = buidDataSource(ds);
				JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
				dsDao = createMysqlDsDao(jdbcTemplate);
			}

			if (Objects.isNull(dsDao)) {
				throw new JobExecutionException("数据源类型尚不支持");
			}

			// 获取所有的表名
			List<String> tableNames = dsDao.getTableNames();
			if (!CommonUtils.isEmpty(tableNames)) {
				for (String tableName : tableNames) {

					List<Column> columns = dsDao.getColumns(tableName);
					String csvOutFile  = csvOutPath + File.pathSeparatorChar + tableName + File.pathSeparatorChar  + DateUtils.getFullDateTime() + ".csv" ;
					Writer fileWriter = new FileWriter(csvOutPath);
					String[] headers = getHeaders(columns);

					CSVWriter writer = new CSVWriter(fileWriter);
					writer.writeNext(headers);

					Page page = new Page(1000);
					while(true) {
						List<String[]> result = dsDao.getData(tableName, headers, page);
						writer.writeAll(result);

						if (result.size() < 1000) {
							break;
						} else {
							page.next();
						}
					}
				}
			}
		} catch (JobExecutionException ex) {
    		throw ex;
		} catch (Exception ex) {
    		throw new JobExecutionException(ex);
		}

    }

    private String[] getHeaders(List<Column> columns) {
    	String[] headers = new String[columns.size()];
    	for (int i=0; i< columns.size();i++) {
    		headers[i] = columns.get(i).getField();
		}
    	return headers;
	}


    private DsDao createMysqlDsDao(JdbcTemplate jdbcTemplate) {
    	return new MySqlDsDao(jdbcTemplate);
	}

    private DataSource buidDataSource(Database ds) {
		HikariDataSource hds = new HikariDataSource();
		hds.setDriverClassName(ds.getDriver());
		hds.setJdbcUrl(ds.getUrl());
		hds.setUsername(ds.getUsername());
		hds.setPassword(ds.getPassword());
		return hds;
	}


	public String getCsvOutPath() {
		return csvOutPath;
	}

	public CsvJob setCsvOutPath(String csvOutPath) {
		this.csvOutPath = csvOutPath;
		return this;
	}

	public String getDataBaseName() {
		return dataBaseName;
	}

	public CsvJob setDataBaseName(String dataBaseName) {
		this.dataBaseName = dataBaseName;
		return this;
	}

	public String getSender() {
		return sender;
	}

	public CsvJob setSender(String sender) {
		this.sender = sender;
		return this;
	}
}
