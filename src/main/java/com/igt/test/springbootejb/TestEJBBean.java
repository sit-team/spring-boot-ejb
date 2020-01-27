package com.igt.test.springbootejb;

import javax.ejb.*;
import javax.interceptor.*;

import org.springframework.beans.factory.annotation.*;

@Stateless @LocalBean @Remote(TestEJBRemote.class)
@Interceptors(StaticSpringBeanAutowiringInterceptor.class)
public class TestEJBBean implements TestEJBRemote {

	@Autowired private TestBean test;

	public String hello(String name) {
		return test.hello(name);
	}
}
