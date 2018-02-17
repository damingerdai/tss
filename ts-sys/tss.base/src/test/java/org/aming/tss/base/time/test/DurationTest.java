package org.aming.tss.base.time.test;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * @author daming
 * @version 2018/2/16.
 */
public class DurationTest {

	@Test
	public void testDuration() throws InterruptedException {
		Instant begin = Instant.now();
		TimeUnit.SECONDS.sleep(12L);
		for (int i=0;i<1000;i++) {
			Instant.now();
		}
		Instant end  = Instant.now();
		Duration duration = Duration.between(begin, end);

		System.out.println(duration.getSeconds());
		System.out.println(duration.toMillis() / 1000.0);
	}
}
