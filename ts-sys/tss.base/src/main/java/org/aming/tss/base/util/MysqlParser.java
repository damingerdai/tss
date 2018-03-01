package org.aming.tss.base.util;

import org.aming.tss.base.ds.Page;

import java.text.MessageFormat;

/**
 * @author daming
 * @version 2018/2/27.
 */
public class MysqlParser {

	public static String select(String tableName, String...columnNames) {
		String sql = "select {0} from {1}";
		StringBuilder sb = new StringBuilder();
		for (String columnName : columnNames) {
			sb.append(columnName).append(",");
		}
		return MessageFormat.format(sql, sb.substring(0, sb.length()-1), tableName);
	}

	public static String selectLimit(String tableName, String[] columnNames, Page page) {
		return select(tableName, columnNames) + " limit " + page.getPage() + "," + page.getPageSize();
	}

	public static void main(String[] args) {
		String tablesName = "qrtz_job";
		String[] columnNames = {"id", "job_code", "job_name"};
		Page page = new Page(100);
		String sql = selectLimit(tablesName, columnNames, page);
		System.err.println(sql);
	}

}
