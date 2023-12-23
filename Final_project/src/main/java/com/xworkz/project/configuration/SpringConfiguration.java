package com.xworkz.project.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import lombok.extern.slf4j.Slf4j;

@Configuration
@ComponentScan("com.xworkz.project")
@Slf4j
public class SpringConfiguration {

	public SpringConfiguration() {
		log.info("created : " + this.getClass().getSimpleName());
	}

	@Bean
	public ViewResolver getViewResolver() {
		log.info("creating ViewResolver...........");

		return new InternalResourceViewResolver("/", ".jsp");
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
		log.info("creating LocalContainerEntityManagerFactoryBean...........");

		return new LocalContainerEntityManagerFactoryBean();
	}
	
	@Bean
    public MultipartResolver multipartResolver() {
		log.info("creating MultipartResolver...........");
        return new StandardServletMultipartResolver();
        
        
    }
	
	
}
