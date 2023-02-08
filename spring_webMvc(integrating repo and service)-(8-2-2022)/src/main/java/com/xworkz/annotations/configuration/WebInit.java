package com.xworkz.annotations.configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	public WebInit() {
		System.out.println("created : " + this.getClass().getSimpleName());
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Running getRootConfigClasses method......");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		System.out.println("Running getServletConfigClasses method......");
		Class[] arr = { SpringConfiguration.class };

		return arr;
	}

	@Override
	protected String[] getServletMappings() {

		System.out.println("Running getServletMappings method......");
		String[] arr = { "/" };
		return arr;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("ruuning configureDefaultServletHandling method.......");

		configurer.enable();
	}

}
