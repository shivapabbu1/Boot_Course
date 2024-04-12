package com.BootBeanConfig.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.BootBeanConfig.demo.controller.CarController;
import com.BootBeanConfig.demo.service.Car;
import com.BootBeanConfig.demo.service.Honda;
import com.BootBeanConfig.demo.service.Tata;

@SpringBootApplication
public class BootBeanConfigApplication {

	
	public static void main(String[] args) {
	SpringApplication.run(BootBeanConfigApplication.class, args);
		
//		CarController carController=context.getBean(CarController.class);
//		System.out.println(carController.getCar());
				
//	Tata tata=	 context.getBean(Tata.class);
//	 System.out.println(tata.getCar());
	 
//				
//	 Honda honda=	 context.getBean(Honda.class);
//	 System.out.println(honda.getCar());
	 
	}

}
