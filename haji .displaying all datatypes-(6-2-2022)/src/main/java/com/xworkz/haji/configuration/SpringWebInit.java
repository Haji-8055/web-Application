package com.xworkz.haji.configuration;

import java.util.Arrays;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringWebInit extends AbstractAnnotationConfigDispatcherServletInitializer implements WebMvcConfigurer {

	public SpringWebInit() {
		System.out.println("created SpringWebInit..");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {

		System.out.println("running getRootConfigClasses method....");

		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		System.out.println("running getServletConfigClasses method....");

		Class[] ref = { SpringBeanConfiguration.class };
		System.out.println("printing  : " + Arrays.toString(ref));
		return ref;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("running getServletMappings method....");
		String[] arr = { "/" };
		System.out.println("printing  : " + Arrays.toString(arr));

		return arr;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		System.out.println("running configureDefaultServletHandling method...........");
		
		configurer.enable();
	}

}
