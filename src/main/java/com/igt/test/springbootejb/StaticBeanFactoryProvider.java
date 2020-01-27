package com.igt.test.springbootejb;

import javax.annotation.*;

import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;

@Configuration
public class StaticBeanFactoryProvider {

	@Autowired private ConfigurableApplicationContext context;
	private static BeanFactory beanFactory;

	@PostConstruct
	public void init() {
		beanFactory = context.getBeanFactory();
	}

	@PreDestroy
	public void destroy() {
		beanFactory = null;
	}

	public static BeanFactory getBeanFactory() {
		if (beanFactory == null)
			throw new IllegalStateException("Static BeanFactory is not available");
		return beanFactory;
	}
}
