package com.xworkz.model.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.model")
public class SpringBeanConfiguration {

	public SpringBeanConfiguration() {

		System.out.println("created SpringBeanConfiguration...");
	}

}
