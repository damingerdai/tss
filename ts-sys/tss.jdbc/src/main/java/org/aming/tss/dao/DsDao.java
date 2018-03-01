package org.aming.tss.dao;

import org.aming.tss.base.ds.Page;
import org.aming.tss.base.ds.mysql.Column;
import org.aming.tss.base.exception.TssException;

import java.sql.ResultSet;
import java.util.List;

/**
 * @author daming
 * @version 2018/2/25.
 */
public interface DsDao {

	String getDataSourceName() throws TssException;

	List<String> getTableNames() throws TssException;

	List<Column> getColumns(String tableName) throws TssException;

	ResultSet getResultSet(Column table) throws TssException;

	List<String[]> getData(String tables, String[] columnNames, Page page) throws TssException;
}
