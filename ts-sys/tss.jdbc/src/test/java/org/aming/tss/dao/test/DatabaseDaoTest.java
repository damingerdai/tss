package org.aming.tss.dao.test;

import com.zaxxer.hikari.HikariDataSource;
import org.aming.tss.dao.DatabaseDao;
import org.aming.tss.dao.impl.DatabaseDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author daming
 * @version 2018/2/17.
 */
@RunWith(SpringRunner.class)
@Import({DatabaseDaoImpl.class})
@SpringBootTest(classes = DatabaseDaoImpl.class, properties = "classpath*:application.properties")
public class DatabaseDaoTest {

	@Autowired
	private DatabaseDao databaseDao;


	@Test
	public void testAutowired() {
		databaseDao.getAllDataBase();
	}

}
