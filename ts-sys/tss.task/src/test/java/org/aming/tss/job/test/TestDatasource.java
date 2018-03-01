package org.aming.tss.job.test;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author daming
 * @version 2018/2/25.
 */
public class TestDatasource {

	private static JdbcTemplate jdbcTemplate;

	@BeforeClass
	public static void begin() {
		HikariDataSource hds = new HikariDataSource();
		hds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		hds.setJdbcUrl("jdbc:mysql://localhost/quartzapp?serverTimezone=GMT%2B8&useSSL=false");
		hds.setUsername("root");
		hds.setPassword("267552");
		jdbcTemplate = new JdbcTemplate(hds);
	}


	@Test
	public void testShowTables() {
		jdbcTemplate.query("show databases", rs -> {
			System.out.println(rs.getObject(1));
		});

	}

	@Test
	public void testShowTablesDetail() {
		jdbcTemplate.query("desc `database`", rs -> {
			System.out.println(rs.getString("Field") + "\t" + rs.getString(2)+ "\t" + rs.getBoolean(3));
		});

	}

}
