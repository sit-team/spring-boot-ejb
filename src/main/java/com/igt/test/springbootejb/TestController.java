package com.igt.test.springbootejb;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired private TestEJBBean testEJB;
	@Autowired private TestBean test;

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(defaultValue = "Spring") String name) {
		return test.hello(name);
	}

	@GetMapping("/helloEJB")
	public String helloEJB(@RequestParam(defaultValue = "EJB") String name) {
		return testEJB.hello(name);
	}
}
