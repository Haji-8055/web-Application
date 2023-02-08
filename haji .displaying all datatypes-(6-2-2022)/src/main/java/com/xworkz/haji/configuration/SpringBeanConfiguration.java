package com.xworkz.haji.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.xworkz.haji")
public class SpringBeanConfiguration {

	public SpringBeanConfiguration() {

		System.out.println("created SpringBeanConfiguration...");
	}

}
