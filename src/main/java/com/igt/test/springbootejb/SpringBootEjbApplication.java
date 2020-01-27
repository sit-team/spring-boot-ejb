package com.igt.test.springbootejb;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.web.support.*;

@SpringBootApplication
public class SpringBootEjbApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEjbApplication.class, args);
	}
}
