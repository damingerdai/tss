package org.aming.core.service.test;

import org.aming.config.ErrorConfig;
import org.aming.core.service.ErrorCodeService;
import org.aming.core.service.impl.ErrorCodeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author daming
 * @version 2018/2/11.
 */
@RunWith(SpringRunner.class)
@Import(ErrorCodeServiceImpl.class)
@SpringBootTest(classes = ErrorConfig.class)
public class ErrorCodeServiceTest {

	@Autowired
	private ErrorCodeService errorCodeService;

	@Test
	public void testApplicationContext() {
		String message = errorCodeService.getErrorMessage("ER-10001");
		assert message.equals("fail to execute sql {0}");
	}


}
