package com.BootBeanConfig.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.BootBeanConfig.demo.controller.CarController;
import com.BootBeanConfig.demo.service.Car;
import com.BootBeanConfig.demo.service.Honda;
import com.BootBeanConfig.demo.service.Tata;

@Configuration
public class AppConfig {

	
	@Bean
	public Car tata() {
		return new Tata();
	}
	

	@Bean
	@Primary
	public Car honda() {
		return new Honda();
	}
	 

//	@Bean
//	public CarController carController() {
//		return new CarController(honda());
//	}
	
	
}
