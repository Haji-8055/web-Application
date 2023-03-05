package com.xworkz.sql.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan("com.xworkz")
public class SpringConfiguration {

	public SpringConfiguration() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Bean
	public ViewResolver viewResolver() {
		System.out.println("created viewResolver");
		ViewResolver resolver = new InternalResourceViewResolver("/", ".jsp");
		return resolver;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean() {
		System.out.println("registering LocalContainerEntityManagerFactoryBean............");
		
		LocalContainerEntityManagerFactoryBean containerEntityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
		
		return containerEntityManagerFactoryBean;
	}

	

}
