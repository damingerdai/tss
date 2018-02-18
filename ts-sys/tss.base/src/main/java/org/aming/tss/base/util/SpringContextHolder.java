package org.aming.tss.base.util;

import org.springframework.context.ApplicationContext;
import org.springframework.util.Assert;

/**
 * @author daming
 * @version 2018/2/17.
 */
public class SpringContextHolder {

	private static ApplicationContext applicationContext;

	public static void setApplicationContext(ApplicationContext context) {
		Assert.notNull(context, "Params 'context' is required");
		applicationContext = context;
	}

	public static <T> T getBean(Class<T> classType) {
		Assert.notNull(applicationContext, "Property 'applicationContext' is required");
		return applicationContext.getBean(classType);
	}

	public static <T> T getBean(String beanName, Class<T> classType) {
		Assert.notNull(applicationContext, "Property 'applicationContext' is required");
		return applicationContext.getBean(beanName, classType);
	}

	public static Object getBean(String beanName) {
		Assert.notNull(applicationContext, "Property 'applicationContext' is required");
		return applicationContext.getBean(beanName);
	}
}
