package org.aming.core.service.test;

import org.junit.Test;
import org.quartz.Trigger;

/**
 * @author daming
 * @version 2018/3/3.
 */
public class ScheduleServiceTest {

	@Test
	public void test() {
		Trigger.TriggerState  state = Trigger.TriggerState.ERROR;
		System.out.println(state.ordinal());

	}

}
