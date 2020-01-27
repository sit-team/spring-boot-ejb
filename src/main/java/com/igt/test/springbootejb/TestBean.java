package com.igt.test.springbootejb;

import org.springframework.stereotype.*;

@Component
public class TestBean {

	public String hello(String name) {
		return "Hello " + name + "!";
	}
}
