package com.Boot_BeanLifeCycle.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// @ImportResource("classpath:beans.xml")
@SpringBootApplication

public class BootBeanLifeCycleApplication {

	public static void main(String[] args) {
	 	SpringApplication.run(BootBeanLifeCycleApplication.class, args);

	}

}
