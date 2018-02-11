package org.aming.core.service.test;

import org.aming.config.ErrorConfig;
import org.aming.core.service.ErrorCodeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author daming
 * @version 2018/2/11.
 */
@RunWith(SpringRunner.class)
@Configurable
@SpringBootTest(classes = {ErrorConfig.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class ErrorCodeServiceTest {

	@Autowired
	private ErrorCodeService errorCodeService;

	@Test
	public void testErrorCodeService() {
		String errorMessage = errorCodeService.getErrorMessage("10001");
		assert errorMessage.equals("fail to execute sql {0}");
	}
}
