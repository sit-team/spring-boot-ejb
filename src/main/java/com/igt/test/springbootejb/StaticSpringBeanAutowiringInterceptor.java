package com.igt.test.springbootejb;

import javax.annotation.*;
import javax.ejb.*;
import javax.interceptor.*;

import org.springframework.beans.factory.annotation.*;

/**
 * Support for injecting Spring Beans into EJB Beans
 */
public class StaticSpringBeanAutowiringInterceptor {

	@PostConstruct	@PostActivate
	public void autowireBean(InvocationContext invocationContext) throws Exception {
		doAutowireBean(invocationContext.getTarget());
		invocationContext.proceed();
	}

	private void doAutowireBean(Object target) {
		AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
		bpp.setBeanFactory(StaticBeanFactoryProvider.getBeanFactory());
		bpp.processInjection(target);
	}
}
