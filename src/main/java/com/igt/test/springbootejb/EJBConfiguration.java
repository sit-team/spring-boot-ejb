package com.igt.test.springbootejb;

import java.util.*;
import javax.ejb.*;
import javax.naming.*;

import org.springframework.context.annotation.*;

/**
 * Support for injecting Local EJBs into Spring Beans
 */
@Configuration
public class EJBConfiguration {

	@Bean
	public InitialContext initialContext() throws NamingException {
		Properties props = new Properties();
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		return new InitialContext(props);
	}

	@Bean
	public TestEJBBean testEJB(InitialContext context) throws NamingException {
		return (TestEJBBean)context.lookup(localName(TestEJBBean.class));
	}

	private static String localName(Class<?> ejbClass) {
		return "java:module/" + ejbClass.getSimpleName() + "!" + ejbLocalName(ejbClass);
	}

	private static String ejbLocalName(Class<?> ejbClass) {
		if (ejbClass.getAnnotation(LocalBean.class) != null)
			return ejbClass.getName();
		for (Class<?> ejbInterface : ejbClass.getInterfaces()) {
			if (ejbInterface.getAnnotation(Local.class) != null)
				return ejbInterface.getName();
		}
		throw new IllegalArgumentException("EJB Bean does not have Local interface: " + ejbClass);
	}
}
