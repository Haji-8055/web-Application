package com.xworkz.requestmap.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.requestmap")
public class SpringBeanConfiguration {
	
	public SpringBeanConfiguration() {
		System.out.println("created SpringBeanConfiguration..........");

	}

}
