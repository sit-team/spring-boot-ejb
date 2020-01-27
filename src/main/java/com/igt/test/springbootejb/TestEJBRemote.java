package com.igt.test.springbootejb;

import javax.ejb.*;

@Remote
public interface TestEJBRemote {

	String hello(String name);
}
