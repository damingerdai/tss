package org.aming.tss.dao.test;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

/**
 * @author daming
 * @version 2018/2/17.
 */
@RunWith(SpringRunner.class)
@Import({HikariDataSource.class})
public class DatasourceTest {

	@Autowired
	private DataSource ds;


	@Test
	public void testDataSource() {
		Assert.assertNotEquals(ds, null);

	}
}
