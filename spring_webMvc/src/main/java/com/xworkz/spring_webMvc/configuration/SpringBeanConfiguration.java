package com.xworkz.spring_webMvc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.spring_webMvc")
public class SpringBeanConfiguration {

	public SpringBeanConfiguration() {
		System.out.println("created SpringBeanConfiguration.....");
	}

}
